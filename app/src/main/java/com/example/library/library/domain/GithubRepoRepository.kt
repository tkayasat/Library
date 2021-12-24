package com.example.library.library.domain

import com.example.library.library.model.GithubUserModel

abstract class GithubRepoRepository {

    abstract val reposUrl: String

    abstract fun getRepos(userModel: GithubUserModel)

}