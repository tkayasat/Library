package com.example.library.libone.ui.ui.data

import com.example.library.libone.cache.GithubRepo
import io.reactivex.rxjava3.core.Single

interface GithubRepoCacheDataSource : GithubRepoDataSource {

    fun retain(githubRepo: GithubRepo): Single<GithubRepo>
}