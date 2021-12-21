package com.example.library.newproject_cicerone.di.di.modules

import com.example.library.newproject_cicerone.HW5.domain.GithubRepoRepository
import com.example.library.newproject_cicerone.HW5.domain.GithubRepoRepositoryImpl
import com.example.library.newproject_cicerone.db.db.AppDatabase
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepository
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepositoryImpl
import com.example.library.newproject_cicerone.remote.RetrofitService
import com.example.library.newproject_cicerone.remote.connectivity.NetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun usersRepo(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUsersRepository {
        return GithubUsersRepositoryImpl(networkStatus, retrofitService, db)
    }


    @Provides
    fun reposRepo(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUsersRepository {
        return GithubUsersRepositoryImpl(networkStatus, retrofitService, db)
    }
}