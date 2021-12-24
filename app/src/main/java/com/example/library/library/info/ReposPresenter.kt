package com.example.library.library.info

import com.example.library.library.cache.IGithubRepoRepos
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