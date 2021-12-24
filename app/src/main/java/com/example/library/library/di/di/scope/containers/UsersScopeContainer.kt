package com.example.library.library.di.di.scope.containers

import com.example.library.library.di.di.components.GithubUsersSubcomponent

interface UsersScopeContainer {
    fun initUsersSubcomponent(): GithubUsersSubcomponent

    fun destroyUsersSubcomponent()
}