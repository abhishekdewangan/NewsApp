package news_category.view

import base.BasePresenterImpl
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.launch
import news_category.domain.*
import kotlin.coroutines.CoroutineContext

class NewsCategoryPresenter constructor(
    context: CoroutineContext,
    private val newsCategoriesVMMapper: NewsCategoriesVMMapper,
    private val getNewsCategories: GetNewsCategories,
    private val selectCategory: SelectCategory,
    private val selectedNewsCategories: GetSelectedNewsCategories
) : BasePresenterImpl<NewsCategoryContract.View>(context), NewsCategoryContract.Presenter {


    override fun start() {
        initialRender()
        launch { subscribeToSelectedCategory() }
    }

    override fun onCategorySelected(categoryName: String) {
        launch {
           selectCategory(categoryName)
        }
    }

    private fun initialRender() {
        newsCategoriesVMMapper.map(getNewsCategories(), emptyList())
            .apply { view.render(this) }
    }

    private suspend fun subscribeToSelectedCategory() {
        selectedNewsCategories()
            .map { newsCategoriesVMMapper.map(getNewsCategories(), it) }
            .consumeEach { view.render(it) }
    }

}