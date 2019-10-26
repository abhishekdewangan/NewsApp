package com.sample.newsapp.application

import android.content.Context
import android.content.SharedPreferences
import com.russhwolf.settings.AndroidSettings
import com.russhwolf.settings.Settings
import constants.SharedPrefConstants
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class RootDataModule(private val appContext: Context) {

    val rootDataModule = Kodein.Module("RootDataModule") {
        val sharedPreferences = appContext
            .getSharedPreferences(SharedPrefConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        bind<SharedPreferences>() with singleton { sharedPreferences }
        bind<Settings>() with singleton { AndroidSettings(instance()) }
    }

}