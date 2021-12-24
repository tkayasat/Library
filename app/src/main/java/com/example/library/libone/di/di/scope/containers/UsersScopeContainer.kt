package com.example.library.libone.di.di.scope.containers

import com.example.library.libone.di.di.components.GithubUsersSubcomponent

interface UsersScopeContainer {
    fun initUsersSubcomponent(): GithubUsersSubcomponent

    fun destroyUsersSubcomponent()
}