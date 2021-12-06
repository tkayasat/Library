package com.example.library.newproject_cicerone.model.domain

import com.example.library.newproject_cicerone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubUsersRepository {
    private val users = listOf(
        GithubUserModel("Login 1"),
        GithubUserModel("Login 2"),
        GithubUserModel("Login 3"),
        GithubUserModel("Login 4"),
        GithubUserModel("Login 5"),
    )

    fun getUsers(): Single<List<GithubUserModel>> {
        return Single.just(users)
    }
}