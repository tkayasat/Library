package com.example.library.libone.datacache

import com.example.library.libone.model.GithubUserModel
import com.example.library.libone.remote.RetrofitService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUserDataSourceImpl
    @Inject constructor(
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