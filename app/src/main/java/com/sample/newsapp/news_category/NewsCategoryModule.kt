package com.sample.newsapp.news_category

import news_category.domain.NewsCategoryDomainModule
import news_category.view.NewsCategoryViewModule
import org.kodein.di.Kodein
import kotlin.coroutines.CoroutineContext

class NewsCategoryModule(private val coroutineContext: CoroutineContext) {

    val newsCategoryModule = Kodein.Module("NewsCategoryModule") {
        import(NewsCategoryPlatformModule(coroutineContext).platformModule)
        import(NewsCategoryViewModule.viewModule)
        import(NewsCategoryDomainModule.domainModule)
    }
}