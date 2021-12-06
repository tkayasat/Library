package com.example.library.newproject_cicerone.ui.ui.users

import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepository
import com.example.library.newproject_cicerone.screens.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(

    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView.UsersView>() {

    val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()
    }

    private fun loadData() {
        disposables.add(
            usersRepository
                .getUsers()
                .subscribe(::handleUsers, viewState::showError)
        )
    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(AppScreens.userDetailScreen(userModel.login))
    }

    private fun handleUsers(users: List<GithubUserModel>) {
        viewState.updateList()
    }

    fun destroyView(view: UsersView?) {
        disposables.dispose()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
