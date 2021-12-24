package com.example.library.library.di.di.scope.containers

import com.example.library.library.di.di.components.GithubRepoSubcomponent

interface ReposScopeContainer {
    fun initRepoSubcomponent(): GithubRepoSubcomponent

    fun destroyRepoSubcomponent()
}