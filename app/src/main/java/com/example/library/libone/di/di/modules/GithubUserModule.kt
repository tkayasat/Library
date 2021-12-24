package com.example.library.libone.di.di.modules

import com.example.library.libone.cache.GithubUserCache
import com.example.library.libone.datacache.GithubUsersRepositoryImpl
import com.example.library.libone.cache.db.AppDatabase
import com.example.library.libone.di.di.scope.UsersScope
import com.example.library.libone.di.di.scope.containers.UsersScopeContainer
import com.example.library.libone.domain.GithubUsersRepository
import com.example.library.libone.ui.ui.App
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GithubUserModule {

    @UsersScope
    @Binds
    protected abstract fun usersRepository(impl: GithubUsersRepositoryImpl): GithubUsersRepository

    companion object {

        @UsersScope
        @Provides
        fun userCache(db: AppDatabase): GithubUserCache {
            return GithubUserCache(db)
        }

        @UsersScope
        @Provides
        fun scopeContainer(app: App): UsersScopeContainer = app
    }
}