package com.example.library.newproject_cicerone.ui.ui.users

import com.example.library.newproject_cicerone.model.GithubUserModel
import moxy.MvpView

class UsersView {
    interface UsersView : MvpView {
        fun showError(err: Throwable)
        fun init()
        fun updateList(users: List<GithubUserModel>)
    }
}