package news_category.view

import base.BasePresenterImpl
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.launch
import news_category.domain.*
import kotlin.coroutines.CoroutineContext

class NewsCategoryPresenter constructor(
    context: CoroutineContext,
    private val newsCategoryRepo: NewsCategoryRepo,
    private val newsCategoriesVMMapper: NewsCategoriesVMMapper
) : BasePresenterImpl<NewsCategoryContract.View>(context), NewsCategoryContract.Presenter {

    private val newsCategories = GetNewsCategories(newsCategoryRepo).invoke()

    override fun start() {
        initialRender()
        launch { subscribeToSelectedCategory() }
    }

    override fun onCategorySelected(categoryName: String) {
        launch {
            SelectCategory(newsCategoryRepo).invoke(categoryName)
        }
    }

    private fun initialRender() {
        newsCategoriesVMMapper.map(newsCategories, emptyList())
            .apply { view.render(this) }
    }

    private suspend fun subscribeToSelectedCategory() {
        GetSelectedNewsCategories(newsCategoryRepo).invoke()
            .map { newsCategoriesVMMapper.map(newsCategories, it) }
            .consumeEach {
                println("NewsCategoryPresenter :: $it")
                view.render(it)
            }

    }

}