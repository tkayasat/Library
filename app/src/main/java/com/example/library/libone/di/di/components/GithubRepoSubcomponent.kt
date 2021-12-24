package com.example.library.libone.di.di.components

import com.example.library.libone.di.di.modules.GithubRepoModule
import com.example.library.libone.di.di.scope.RepositoryScope
import com.example.library.libone.ui.ui.repos.ReposPresenterFactory
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        GithubRepoModule::class
    ]
)
interface GithubRepoSubcomponent {

    fun reposPresenterFactory(): ReposPresenterFactory
}