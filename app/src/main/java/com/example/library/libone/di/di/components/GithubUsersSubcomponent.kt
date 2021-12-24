package com.example.library.libone.di.di.components

import com.example.library.libone.di.di.modules.GithubUserModule
import com.example.library.libone.di.di.scope.UsersScope
import com.example.library.libone.ui.ui.users.UsersPresenter
import dagger.Subcomponent

@UsersScope
@Subcomponent(
    modules = [
        GithubUserModule::class,
    ]
)
interface GithubUsersSubcomponent {

    fun repoSubcomponent(): GithubRepoSubcomponent

    fun provideUsersPresenter(): UsersPresenter
}