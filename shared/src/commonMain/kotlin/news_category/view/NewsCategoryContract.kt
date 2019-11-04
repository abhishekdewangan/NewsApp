package news_category.view

import base.BasePresenter
import base.BaseView

interface NewsCategoryContract {
  interface View : BaseView {
    fun render(viewModel: NewsCategoriesVM)
  }

  interface Presenter : BasePresenter<View> {
    fun onCategorySelected(categoryName: String)
  }
}