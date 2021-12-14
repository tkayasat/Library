package com.example.library.newproject_cicerone.HW5.info

import com.example.library.newproject_cicerone.HW5.GithubRepo
import com.example.library.newproject_cicerone.HW5.IGithubRepoRepos
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class ReposPresenter (
    private val url: String,
    private val repoRepository: IGithubRepoRepos,
) : MvpPresenter<ReposView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
           super.onFirstViewAttach()
            viewState.init()
    }
}