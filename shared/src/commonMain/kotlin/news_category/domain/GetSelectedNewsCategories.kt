package news_category.domain

import kotlinx.coroutines.channels.ReceiveChannel

class GetSelectedNewsCategories constructor(private val newsCategoryRepo: NewsCategoryRepo) {

    operator fun invoke(): ReceiveChannel<List<NewsCategory>> {
        return newsCategoryRepo.getSelectedCategories()
    }
}