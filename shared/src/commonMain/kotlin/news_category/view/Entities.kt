package news_category.view

class NewsCategoriesVM(val categoriesVM: List<NewsCategoryVM>)

class NewsCategoryVM(val name: String, val isSelected: Boolean)