package com.example.library.newproject_cicerone.ui.ui.users

import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepository
import com.example.library.newproject_cicerone.screens.AppScreens
import com.example.library.newproject_cicerone.ui.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView.UsersView>() {

    val usersListPresenter = UsersListPresenter(router)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

     class UsersListPresenter(router: Router) : IListPresenter<UsersItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: ((UsersItemView) -> Unit)? =
            { router.navigateTo(AppScreens.userDetailScreen(users[it.pos].login)) }

        override fun getCount() = users.size

        override fun bindView(view: UsersItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}