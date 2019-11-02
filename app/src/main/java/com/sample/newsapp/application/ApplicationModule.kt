package com.sample.newsapp.application

import android.content.Context
import constants.DependencyInjectionConstants.Companion.SCOPE_APPLICATION
import network.NetworkModule
import news_category.data.NewsCategoryDataModule
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import kotlin.coroutines.CoroutineContext

class ApplicationModule(private val context: Context,private val coroutineContext: CoroutineContext) {

    val applicationModule = Kodein.Module("ApplicationModule") {
        bind<CoroutineContext>(tag = SCOPE_APPLICATION) with singleton { coroutineContext }
        import(NetworkModule.networkModule)
        import(RootDataModule(context).rootDataModule)
        import(NewsCategoryDataModule.dataModule)
    }

}