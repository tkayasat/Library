package com.example.library.newproject_cicerone.HW5.domain

import com.example.library.newproject_cicerone.model.GithubRepoModel
import com.example.library.newproject_cicerone.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

abstract class GithubRepoRepository   {

    abstract val reposUrl: String

    abstract fun getRepos(userModel: GithubUserModel)

}