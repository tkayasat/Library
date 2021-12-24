package com.example.library.library.ui.ui

import android.app.Application
import com.example.library.library.di.di.components.AppComponent
import com.example.library.library.di.di.components.DaggerAppComponent
import com.example.library.library.di.di.components.GithubRepoSubcomponent
import com.example.library.library.di.di.components.GithubUsersSubcomponent
import com.example.library.library.di.di.modules.AppModule
import com.example.library.library.di.di.scope.containers.ReposScopeContainer
import com.example.library.library.di.di.scope.containers.UsersScopeContainer
import com.github.terrakok.cicerone.Router
import kotlin.reflect.KProperty


class App(val router: Router) : Application(), UsersScopeContainer, ReposScopeContainer {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
        .build()
    }

    var usersSubcomponent: GithubUsersSubcomponent? = null

    var repoSubcomponent: GithubRepoSubcomponent? = null


    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    override fun initUsersSubcomponent() = appComponent.userSubcomponent().also {
        usersSubcomponent = it
    }

    override fun destroyUsersSubcomponent() {
        usersSubcomponent = null
    }

    override fun initRepoSubcomponent() = appComponent.userSubcomponent().repoSubcomponent().also {
        repoSubcomponent = it
    }

    override fun destroyRepoSubcomponent() {
        repoSubcomponent = null
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}