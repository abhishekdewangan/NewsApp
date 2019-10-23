package news_category.domain

enum class NewsCategory(name: String, keyWord: String){
    Business("business", "business"),
    Entertainment("Entertainment", "entertainment"),
    General("General", "general"),
    Health("Health", "health"),
    Science("Science", "science"),
    Sports("Sports", "sports"),
    Technology("technology", "technology")
}
