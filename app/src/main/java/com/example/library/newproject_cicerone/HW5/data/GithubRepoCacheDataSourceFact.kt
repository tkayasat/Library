package com.example.library.newproject_cicerone.HW5.data

import com.example.library.newproject_cicerone.HW5.domain.GithubRepoCacheDataSourceImpl

object GithubRepoCacheDataSourceFact {
    fun create(): GithubRepoCacheDataSource =
        GithubRepoCacheDataSourceImpl()
}