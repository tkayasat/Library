package com.example.library.libone.di.di.modules

import com.example.library.libone.datacache.GithubUsersRepositoryImpl
import com.example.library.libone.domain.GithubRepoRepository
import com.example.library.libone.domain.GithubRepoRepositoryImpl
import com.example.library.libone.domain.GithubUsersRepository
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