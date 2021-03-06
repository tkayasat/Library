package com.example.library.libone.ui.ui.users.userInfo

import com.example.library.libone.domain.GithubUsersRepository
import com.example.library.libone.ui.ui.users.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class InfoUsersPresenter(

    val userId: Int? = null,
    private val githubUsersRepo: GithubUsersRepository,
    val router: Router
) : MvpPresenter<UsersView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}