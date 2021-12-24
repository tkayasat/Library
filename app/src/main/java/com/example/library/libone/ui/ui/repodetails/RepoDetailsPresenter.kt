package com.example.library.libone.ui.ui.users

import com.example.library.libone.model.GithubRepoModel
import com.example.library.libone.ui.ui.repodetails.RepoDetailsView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class RepoDetailsPresenter(
    private val repoModel: GithubRepoModel
) : MvpPresenter<RepoDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showRepoDetails(repoModel)
    }
}