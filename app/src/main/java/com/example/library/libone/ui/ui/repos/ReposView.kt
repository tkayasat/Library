package com.example.library.libone.ui.ui.repos

import com.example.library.libone.model.GithubRepoModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ReposView : MvpView {

    fun showLoading()

    fun hideLoading()

    fun showRepos(repos: List<GithubRepoModel>)
}