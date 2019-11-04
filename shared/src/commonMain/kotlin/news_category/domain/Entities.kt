package news_category.domain

enum class NewsCategory(val categoryName: String, val key: String) {
  Business("business", "business"),
  Entertainment("Entertainment", "entertainment"),
  General("General", "general"),
  Health("Health", "health"),
  Science("Science", "science"),
  Sports("Sports", "sports"),
  Technology("technology", "technology")
}
