package com.example.library.libone.di.di.scope.containers

import com.example.library.libone.di.di.components.GithubRepoSubcomponent

interface ReposScopeContainer {
    fun initRepoSubcomponent(): GithubRepoSubcomponent

    fun destroyRepoSubcomponent()
}