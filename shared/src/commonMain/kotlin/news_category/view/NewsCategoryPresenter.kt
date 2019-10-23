package news_category.view

import base.BasePresenterImpl
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.launch
import news_category.domain.*

class NewsCategoryPresenter constructor(
    private val newsCategoryRepo: NewsCategoryRepo,
    private val newsCategoriesVMMapper: NewsCategoriesVMMapper = NewsCategoriesVMMapper()
) :BasePresenterImpl<NewsCategoryContract.View>(),  NewsCategoryContract.Presenter {

    private val newsCategories = GetNewsCategories(newsCategoryRepo).invoke()


    override fun start() {
        launch {
            GetSelectedNewsCategories(newsCategoryRepo).invoke()
                .map { newsCategoriesVMMapper.map(newsCategories, it) }
                .consumeEach { view.render(it) }
        }
    }

    //todo remaining work
    override fun onCategorySelected(categoryName: String) {

    }


}