package com.example.library.library.ui.ui.repodetails

import com.example.library.library.model.GithubRepoModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepoDetailsView : MvpView {

    @AddToEndSingle
    fun showRepoDetails(repoModel: GithubRepoModel)
}