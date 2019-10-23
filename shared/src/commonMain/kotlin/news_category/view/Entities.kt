package news_category.view

class NewsCategoriesVM(private val categoriesVM: List<NewsCategoryVM>)

class NewsCategoryVM(private val name: String, private val isSelected: Boolean)