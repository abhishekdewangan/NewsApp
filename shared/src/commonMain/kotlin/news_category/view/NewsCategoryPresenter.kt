package news_category.view

import base.BasePresenterImpl
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.launch
import news_category.domain.*

class NewsCategoryPresenter constructor(
    private val newsCategoryRepo: NewsCategoryRepo,
    private val newsCategoriesVMMapper: NewsCategoriesVMMapper = NewsCategoriesVMMapper()
) : BasePresenterImpl<NewsCategoryContract.View>(), NewsCategoryContract.Presenter {

    private val newsCategories = GetNewsCategories(newsCategoryRepo).invoke()

    override fun start() {
        inititalRender()
        launch { susbscribeToSelectedCategory() }
    }

    //todo remaining work
    override fun onCategorySelected(categoryName: String) {

    }

    private fun inititalRender() {
        newsCategoriesVMMapper.map(newsCategories, emptyList())
            .apply { view.render(this) }
    }

    private suspend fun susbscribeToSelectedCategory() {
        GetSelectedNewsCategories(newsCategoryRepo).invoke()
            .map { newsCategoriesVMMapper.map(newsCategories, it) }
            .consumeEach {
                println("NewsCategoryPresenter :: $it")
                view.render(it)
            }

    }

}