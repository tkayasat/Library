package com.example.library.newproject_cicerone.ui.ui.users

import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepository
import com.example.library.newproject_cicerone.ui.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView.UsersView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        usersListPresenter.itemClickListener = {}
        router.navigateTo() //TODO

    }

    private fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }

     class UsersListPresenter : IListPresenter<UsersItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener = { }

        override fun getCount() = users.size

        override fun bindView(view: UsersItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}