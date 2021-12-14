package com.example.library.newproject_cicerone.HW5.data

import com.example.library.newproject_cicerone.HW5.GithubRepo
import io.reactivex.rxjava3.core.Single

interface GithubRepoDataSource {

    fun getRepo(url: String): Single<GithubRepo>
}