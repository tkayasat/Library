package com.example.library.libone.cache

import io.reactivex.rxjava3.core.Observable


interface IGithubRepoRepos {
    fun getRepo(url: String): Observable<GithubRepo>
}