package com.example.library.newproject_cicerone.ui.ui.users.userInfo

import com.example.library.newproject_cicerone.model.domain.GithubUsersRepository
import com.example.library.newproject_cicerone.ui.ui.users.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class InfoUsersPresenter(

    val userId: Int? = null,
    private val githubUsersRepo: GithubUsersRepository,
    val router: Router
) : MvpPresenter<UsersView.UsersView>() {

    // override fun onFirstViewAttach() {
    //   val currentUser = githubUsersRepo.getUsers().firstOrNull { it.id == userId } ошибка с id

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}