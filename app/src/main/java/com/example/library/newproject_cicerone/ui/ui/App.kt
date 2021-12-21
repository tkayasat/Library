package com.example.library.newproject_cicerone.ui.ui

import android.app.Application
import com.example.library.newproject_cicerone.di.di.components.AppComponent
import com.example.library.newproject_cicerone.di.di.modules.ContextModule


class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }


    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}