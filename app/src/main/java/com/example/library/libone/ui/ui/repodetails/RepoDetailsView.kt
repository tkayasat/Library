package com.example.library.libone.ui.ui.repodetails

import com.example.library.libone.model.GithubRepoModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepoDetailsView : MvpView {

    @AddToEndSingle
    fun showRepoDetails(repoModel: GithubRepoModel)
}