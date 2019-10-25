package news_category.domain

import kotlinx.coroutines.channels.ReceiveChannel

interface NewsCategoryRepo {
    fun getAll(): List<NewsCategory>
    fun getSelectedCategoriesChannel(): ReceiveChannel<List<NewsCategory>>
    fun getSelectedCategories(): List<NewsCategory>
    suspend fun remove(category: NewsCategory)
    suspend fun add(category: NewsCategory)
}