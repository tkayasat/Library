package com.example.library.library.di.di.components

import com.example.library.library.di.di.modules.GithubUserModule
import com.example.library.library.di.di.scope.UsersScope
import com.example.library.library.ui.ui.users.UsersPresenter
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