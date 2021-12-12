package com.example.library.newproject_cicerone.remote

import com.example.library.newproject_cicerone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>
}