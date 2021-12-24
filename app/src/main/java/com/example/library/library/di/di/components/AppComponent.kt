package com.example.library.library.di.di.components

import com.example.library.library.di.di.modules.*
import com.example.library.library.ui.ui.main.MainActivity
import com.example.library.library.ui.ui.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        CiceroneModule::class,
        AppModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent {

    fun userSubcomponent(): GithubUsersSubcomponent

    fun mainPresenter(): MainPresenter

    fun inject(mainActivity: MainActivity)
    fun inject()

}