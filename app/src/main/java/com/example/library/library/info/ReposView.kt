package com.example.library.library.info

import androidx.fragment.app.Fragment
import com.example.library.library.cache.GithubRepo
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ReposView : MvpView {

    @SingleState
    fun showRepo(repos: List<GithubRepo>)

    @SingleState
    fun showError(err: Throwable)
    abstract fun arguments(pair: Pair<String, String>): Fragment
    fun init()
    fun showLoading()
    abstract fun showRepos(repos: Any)
    fun hideLoading()
}