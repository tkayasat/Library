package com.example.library.newproject_cicerone.remote

import com.example.library.newproject_cicerone.HW5.GithubRepo
import com.example.library.newproject_cicerone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>

    @GET
    fun getUserRepos(@Url reposUrl: String): Single<List<GithubRepo>>

    @GET
    fun getUserRepo(@Url repoUrl: String): Single<GithubRepo>

    @GET
    abstract fun getUserByLogin(login: String): Single<GithubUserModel>
}