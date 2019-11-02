package news_category.view

import base.BasePresenterImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
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

    @UseExperimental(ExperimentalCoroutinesApi::class)
    private suspend fun subscribeToSelectedCategory() {
        GetSelectedNewsCategories(newsCategoryRepo).invoke()
            .consumeEach {
                val result =  newsCategoriesVMMapper.map(newsCategories, it)
                view.render(result)
            }
    }

}