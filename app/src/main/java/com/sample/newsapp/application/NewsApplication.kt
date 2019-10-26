package com.sample.newsapp.application

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import kotlin.coroutines.CoroutineContext

class NewsApplication : Application(), CoroutineScope, KodeinAware {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    override val kodein = Kodein.lazy {
        import(ApplicationModule(applicationContext, coroutineContext).applicationModule)
    }

    override fun onTerminate() {
        super.onTerminate()
        job.cancel()
    }
}