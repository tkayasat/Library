package com.example.library.libone.domain

import com.example.library.libone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single


interface GithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>

}