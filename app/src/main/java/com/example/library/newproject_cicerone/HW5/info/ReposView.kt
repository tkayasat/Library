package com.example.library.newproject_cicerone.HW5.info

import androidx.fragment.app.Fragment
import com.example.library.newproject_cicerone.HW5.GithubRepo
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ReposView : MvpView {

    @SingleState
    fun showRepo(repos: List<GithubRepo>)

    @SingleState
    fun showError(err: Throwable)
    abstract fun arguments(pair: Pair<String, String>): Fragment
    fun init()
}