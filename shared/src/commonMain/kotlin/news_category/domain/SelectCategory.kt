package news_category.domain

class SelectCategory constructor(private val newsCategoryRepo: NewsCategoryRepo) {

    suspend operator fun invoke(categoryName: String) {
        val selectedNewsCategories = newsCategoryRepo.getSelectedCategories()
        val selectedNewsCategory = newsCategoryRepo.getAll().find { it.name == categoryName }!!
        val isCategoryAlreadySelected = selectedNewsCategories.any { it == selectedNewsCategory }
        if (isCategoryAlreadySelected) {
            newsCategoryRepo.remove(selectedNewsCategory)
        } else {
            newsCategoryRepo.add(selectedNewsCategory)
        }
    }
}