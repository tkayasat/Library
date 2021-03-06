package com.example.library.libone.ui.ui.users

import com.example.library.libone.model.GithubUserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle


interface UsersView : MvpView {
    fun showError(err: Throwable)
    fun init()

    @AddToEndSingle
    fun updateList(users: List<GithubUserModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
    abstract fun UsersPresenter(): UsersPresenter

}