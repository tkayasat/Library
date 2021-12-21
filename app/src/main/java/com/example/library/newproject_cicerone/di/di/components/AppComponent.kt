package com.example.library.newproject_cicerone.di.di.components

import com.example.library.newproject_cicerone.HW5.info.ReposPresenter
import com.example.library.newproject_cicerone.di.di.modules.*
import com.example.library.newproject_cicerone.main.MainActivity
import com.example.library.newproject_cicerone.main.MainPresenter
import com.example.library.newproject_cicerone.ui.ui.users.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CacheModule::class,
        CiceroneModule::class,
        ContextModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(mainPresenter: MainPresenter)
    fun repoPresenter(): ReposPresenter
    fun inject(mainActivity: MainActivity)
    fun inject(reposPresenter: ReposPresenter)
    fun inject(usersPresenter: UsersPresenter)

}