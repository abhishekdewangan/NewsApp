package news_category.domain

class GetNewsCategories(val newsCategoryRepo: NewsCategoryRepo) {

    operator fun invoke(): List<NewsCategory> {
        return newsCategoryRepo.getAll()
    }
}