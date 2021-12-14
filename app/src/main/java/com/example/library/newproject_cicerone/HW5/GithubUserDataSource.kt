package com.example.library.newproject_cicerone.HW5

import com.example.library.newproject_cicerone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDataSource {
    fun getUsers(): Single<List<GithubUserModel>>

    fun getUserByLogin(login: String): Single<GithubUserModel>
}