package com.example.library.library.ui.ui.data

import com.example.library.library.cache.GithubRepo
import io.reactivex.rxjava3.core.Single

interface GithubRepoDataSource {

    fun getRepo(url: String): Single<GithubRepo>
}