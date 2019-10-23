package news_category.data

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import news_category.domain.NewsCategory
import news_category.domain.NewsCategoryRepo

class NewsCategoryRepoImpl : NewsCategoryRepo {
    private val selectedCategoriesSet = HashSet<NewsCategory>()
    private val selectedCategoryChannel = Channel<List<NewsCategory>>()

    override fun getAll(): List<NewsCategory> {
        return NewsCategory.values().toList()
    }

    override fun getSelectedCategories(): ReceiveChannel<List<NewsCategory>> {
       return selectedCategoryChannel
    }

    override suspend fun remove(category: NewsCategory) {
        selectedCategoriesSet.remove(category)
        selectedCategoryChannel.send(selectedCategoriesSet.toList())
    }

    override suspend fun add(category: NewsCategory) {
        selectedCategoriesSet.add(category)
        selectedCategoryChannel.send(selectedCategoriesSet.toList())
    }

}