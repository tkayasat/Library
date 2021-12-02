package com.example.library.newproject_cicerone.ui.ui

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App: Application() {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    val navigationHolder
        get() = cicerone.getNavigatorHolder()

    val router
        get() = cicerone.router

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