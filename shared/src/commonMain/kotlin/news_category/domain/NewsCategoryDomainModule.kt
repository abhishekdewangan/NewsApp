package news_category.domain

import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

class NewsCategoryDomainModule {
  companion object {
    val domainModule = Kodein.Module("NewsCategoryDomainModule") {
      bind<GetNewsCategories>() with provider { GetNewsCategories(instance()) }
      bind<GetSelectedNewsCategories>() with provider { GetSelectedNewsCategories(instance()) }
      bind<SelectCategory>() with provider { SelectCategory(instance()) }
    }
  }
}