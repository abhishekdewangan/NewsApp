package news_category.view

interface NewsCategoryContract {
    interface View {
        fun render()
    }

    interface Presenter {
        fun setView(view: View)
        fun start()
        fun onCategorySelected(categoryName: String)
    }
}