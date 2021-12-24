package com.example.library.library.domain

import com.example.library.library.model.GithubUserModel
import io.reactivex.rxjava3.core.Single


interface GithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>

}