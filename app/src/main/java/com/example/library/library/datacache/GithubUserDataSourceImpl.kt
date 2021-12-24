package com.example.library.library.datacache

import com.example.library.library.model.GithubUserModel
import com.example.library.library.remote.RetrofitService
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