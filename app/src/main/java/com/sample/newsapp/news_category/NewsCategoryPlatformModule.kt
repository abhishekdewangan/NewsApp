package com.sample.newsapp.news_category

import constants.DependencyInjectionConstants
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import kotlin.coroutines.CoroutineContext

class NewsCategoryPlatformModule(private val coroutineContext: CoroutineContext) {
    val platformModule = Kodein.Module("NewsCategoryPlatformModule") {
        bind<CoroutineContext>(tag = DependencyInjectionConstants.SCOPE_ACTIVITY) with provider { coroutineContext }
    }
}