package com.example.library.library.di.di.modules

import com.example.library.library.datacache.GithubUsersRepositoryImpl
import com.example.library.library.domain.GithubRepoRepository
import com.example.library.library.domain.GithubRepoRepositoryImpl
import com.example.library.library.domain.GithubUsersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUsersRepo(impl: GithubUsersRepositoryImpl): GithubUsersRepository


    @Provides
    @Binds
    abstract fun bindReposRepo(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}