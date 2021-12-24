package com.example.library.library.cache

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepo(
    val owner: Owner,
    val url: String,
    val name: String,
    val forks: Int
) : Parcelable

@Parcelize
data class Owner(
    val login: String
) : Parcelable

object Mapper {

    fun map(repo: GithubRepo) = GithubRepo(repo.owner, repo.url, repo.name, repo.forks)
}