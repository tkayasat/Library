package com.example.library.library.domain

import com.example.library.library.cache.db.AppDatabase
import com.example.library.library.model.GithubUserModel
import com.example.library.library.remote.RetrofitService
import com.example.library.library.remote.connectivity.NetworkStatus
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