package com.example.library.library.datacache

import com.example.library.library.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDataSource {
    fun getUsers(): Single<List<GithubUserModel>>

    fun getUserByLogin(login: String): Single<GithubUserModel>
}