package com.example.library.libone.domain

import com.example.library.libone.model.GithubUserModel

abstract class GithubRepoRepository {

    abstract val reposUrl: String

    abstract fun getRepos(userModel: GithubUserModel)

}