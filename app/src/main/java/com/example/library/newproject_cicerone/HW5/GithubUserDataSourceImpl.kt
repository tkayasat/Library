package com.example.library.newproject_cicerone.HW5

import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUserDataSourceImpl (
    private val retrofitService: RetrofitService
): GithubUserDataSource {

    override fun getUsers(): Single<List<GithubUserModel>> =

        retrofitService
    .getUsers()
    .map { it.sortedBy(GithubUserModel::login) }

    override fun getUserByLogin(login: String): Single<GithubUserModel> =
        retrofitService
            .getUserByLogin(login)
}