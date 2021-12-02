package com.example.library.newproject_cicerone.model.domain

import com.example.library.newproject_cicerone.model.GithubUserModel

class GithubUsersRepository {
    private val users = listOf(
        GithubUserModel("Login 1"),
        GithubUserModel("Login 2"),
        GithubUserModel("Login 3"),
        GithubUserModel("Login 4"),
        GithubUserModel("Login 5"),
    )

    fun getUsers(): List<GithubUserModel> {
        return users
    }
}