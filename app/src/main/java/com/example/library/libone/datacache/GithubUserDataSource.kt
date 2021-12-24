package com.example.library.libone.datacache

import com.example.library.libone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDataSource {
    fun getUsers(): Single<List<GithubUserModel>>

    fun getUserByLogin(login: String): Single<GithubUserModel>
}