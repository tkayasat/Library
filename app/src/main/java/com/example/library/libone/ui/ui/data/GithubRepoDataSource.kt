package com.example.library.libone.ui.ui.data

import com.example.library.libone.cache.GithubRepo
import io.reactivex.rxjava3.core.Single

interface GithubRepoDataSource {

    fun getRepo(url: String): Single<GithubRepo>
}