package com.example.library.library.di.di.components

import com.example.library.library.di.di.modules.GithubRepoModule
import com.example.library.library.di.di.scope.RepositoryScope
import com.example.library.library.ui.ui.repos.ReposPresenterFactory
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