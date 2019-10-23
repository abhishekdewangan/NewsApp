package news_category.domain

class SelectCategory constructor(private val newsCategoryRepo: NewsCategoryRepo) {

    suspend operator fun invoke(newsCategory: NewsCategory) {
        val selectedNewsCategories = newsCategoryRepo.getSelectedCategories().poll()
        val isCategoryAlreadySelected = selectedNewsCategories?.any { it == newsCategory } ?: false
        if (isCategoryAlreadySelected) {
            newsCategoryRepo.remove(newsCategory)
        } else {
            newsCategoryRepo.add(newsCategory)
        }
    }
}