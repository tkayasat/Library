package com.example.library.library.di.di.modules

import com.example.library.library.cache.GithubRepoCache
import com.example.library.library.domain.GithubRepoRepository
import com.example.library.library.domain.GithubRepoRepositoryImpl
import com.example.library.library.cache.db.AppDatabase
import com.example.library.library.di.di.scope.RepositoryScope
import com.example.library.library.di.di.scope.containers.ReposScopeContainer
import com.example.library.library.ui.ui.App
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GithubRepoModule {

    @RepositoryScope
    @Binds
    abstract fun bindReposRepo(impl: GithubRepoRepositoryImpl): GithubRepoRepository

    companion object {

        @RepositoryScope
        @Provides
        fun repoCache(db: AppDatabase): GithubRepoCache {
            return GithubRepoCache(db)
        }

        @RepositoryScope
        @Provides
        fun scopeContainer(app: App): ReposScopeContainer = app
    }
}