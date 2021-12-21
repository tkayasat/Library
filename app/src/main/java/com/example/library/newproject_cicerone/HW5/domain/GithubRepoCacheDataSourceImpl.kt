package com.example.library.newproject_cicerone.HW5.domain

import com.example.library.newproject_cicerone.HW5.GithubRepo
import com.example.library.newproject_cicerone.HW5.data.GithubRepoCacheDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubRepoCacheDataSourceImpl
    @Inject constructor(
      private val githubRepo: GithubRepo
    ) : GithubRepoCacheDataSource {

    private val cache: MutableList<GithubRepo> = mutableListOf()

    fun retain(githubRepos: List<GithubRepo>): Single<List<GithubRepo>> =
        Single.fromCallable {
            cache.clear()
            cache.addAll(githubRepos)
            cache
        }

    override fun retain(githubRepo: GithubRepo): Single<GithubRepo> =
        Single.fromCallable {
            cache.indexOf(githubRepo)
                .takeIf { it != -1 }
                ?.let { cache.removeAt(it); cache.add(githubRepo) }
                ?: cache.add(githubRepo)
            githubRepo
        }

    override fun getRepo(url: String): Single<GithubRepo> =
        Single.defer {
            cache
                .firstOrNull { it.url.equals(url, true) }
                ?.let { Single.just(it) }
                ?: Single.error(RuntimeException("User not found"))
        }
}