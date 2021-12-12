package com.example.library.newproject_cicerone.model.domain

import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoryImpl(
    private val retrofitService: RetrofitService
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return retrofitService.getUsers()
    }
}