package news_category.data

import com.russhwolf.settings.Settings
import constants.SharedPrefConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import news_category.domain.NewsCategory
import news_category.domain.NewsCategoryRepo
import kotlin.coroutines.CoroutineContext

class NewsCategoryRepoImpl(
    private val settings: Settings,
    override val coroutineContext: CoroutineContext
) : NewsCategoryRepo, CoroutineScope {
    private val selectedCategoriesSet: HashSet<NewsCategory> = HashSet()
    private val selectedCategoryChannel = Channel<List<NewsCategory>>()

    init {
        launch {
            initialRepoSetup()
        }
    }

    override fun getAll(): List<NewsCategory> {
        return NewsCategory.values().toList()
    }

    override fun getSelectedCategories(): List<NewsCategory> {
        return selectedCategoriesSet.toList()
    }

    override fun getSelectedCategoriesChannel(): ReceiveChannel<List<NewsCategory>> {
        return selectedCategoryChannel
    }

    override suspend fun remove(category: NewsCategory) {
        selectedCategoriesSet.remove(category)
        updateSelectedCategory()
    }

    override suspend fun add(category: NewsCategory) {
        selectedCategoriesSet.add(category)
        updateSelectedCategory()
    }

    private suspend fun initialRepoSetup() {
        val selectedNewsCategoryKeys = settings
            .getString(SharedPrefConstants.KEY_SELECTED_CATEGORY)
            .split(",")
            .toSet()

        getAll()
            .filter { selectedNewsCategoryKeys.contains(it.key) }
            .apply { selectedCategoriesSet.addAll(this) }

        updateSelectedCategory()
    }

    private suspend fun updateSelectedCategory() {
        selectedCategoryChannel.send(selectedCategoriesSet.toList())

        val selectedCategories = if (selectedCategoriesSet.isEmpty()) "" else {
            selectedCategoriesSet
                .map { it.key }
                .reduce { categoryName1, categoryName2 -> "$categoryName1,$categoryName2" }
        }

        settings.putString(SharedPrefConstants.KEY_SELECTED_CATEGORY, selectedCategories)
    }
}