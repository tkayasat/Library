package com.example.library.newproject_cicerone.HW5

import io.reactivex.rxjava3.core.Observable


interface IGithubRepoRepos {
    fun getRepo(url: String): Observable<GithubRepo>
}