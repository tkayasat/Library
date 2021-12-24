package com.example.library.library.ui.ui.repos

import com.example.library.library.model.GithubRepoModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ReposView : MvpView {

    fun showLoading()

    fun hideLoading()

    fun showRepos(repos: List<GithubRepoModel>)
}