package com.example.library.newproject_cicerone.HW5.domain

import com.example.library.newproject_cicerone.db.db.AppDatabase
import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.remote.RetrofitService
import com.example.library.newproject_cicerone.remote.connectivity.NetworkStatus
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