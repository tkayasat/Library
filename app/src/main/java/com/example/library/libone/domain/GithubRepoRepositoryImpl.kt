package com.example.library.libone.domain

import com.example.library.libone.cache.db.AppDatabase
import com.example.library.libone.model.GithubUserModel
import com.example.library.libone.remote.RetrofitService
import com.example.library.libone.remote.connectivity.NetworkStatus
import javax.inject.Inject

class GithubRepoRepositoryImpl
@Inject constructor(
    private val retrofitService: NetworkStatus,
    retrofitService1: RetrofitService,
    db: AppDatabase, override val reposUrl: String,
) : GithubRepoRepository() {


    override fun getRepos(userModel: GithubUserModel) {
        return retrofitService.getRepo(reposUrl)
    }
}