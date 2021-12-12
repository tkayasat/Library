package com.example.library.newproject_cicerone.model.domain

import com.example.library.newproject_cicerone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single


interface GithubUsersRepository {
    fun getUsers(): Single<List<GithubUserModel>>
}

