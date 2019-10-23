package news_category.view

import kotlinx.coroutines.channels.map
import news_category.domain.*

class NewsCategoryPresenter constructor(
    private val newsCategoryRepo: NewsCategoryRepo,
    private val newsCategoriesVMMapper: NewsCategoriesVMMapper = NewsCategoriesVMMapper(
        NewsCategoryVMMapper()
    )
) : NewsCategoryContract.Presenter {

    private lateinit var view: NewsCategoryContract.View
    private val newsCategories = GetNewsCategories(newsCategoryRepo).invoke()

    override fun setView(view: NewsCategoryContract.View) {
        this.view = view
    }

    // todo remaining work here
    override fun start() {
        GetSelectedNewsCategories(newsCategoryRepo).invoke()
            .map { newsCategoriesVMMapper.map(newsCategories, it) }

    }

    //todo remaining work
    override fun onCategorySelected(categoryName: String) {
    }

}