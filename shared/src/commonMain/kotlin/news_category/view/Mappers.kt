package news_category.view

import news_category.domain.NewsCategory

class NewsCategoriesVMMapper constructor(private val newsCategoryVMMapper: NewsCategoryVMMapper) {

  fun map(newsCategories: List<NewsCategory>, selectedCategories: List<NewsCategory>): NewsCategoriesVM {
        val newsCategoriesVM = newsCategories.map { newsCategoryVMMapper.map(it, selectedCategories) }
        return NewsCategoriesVM(newsCategoriesVM)
    }
}

class NewsCategoryVMMapper {
    fun map(newsCategory: NewsCategory, selectedCategories: List<NewsCategory>): NewsCategoryVM {
        val isSelected = selectedCategories.any { it == newsCategory }
        return NewsCategoryVM(name = newsCategory.name, isSelected = isSelected)
    }
}