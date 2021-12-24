package com.example.library.libone.ui.ui.repos

import com.example.library.libone.di.di.scope.containers.ReposScopeContainer
import com.example.library.libone.domain.GithubRepoRepository
import com.example.library.libone.info.ReposView
import com.example.library.libone.model.GithubUserModel
import com.example.library.libone.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ReposPresenter @AssistedInject constructor(
    private val router: Router,
    private val repo: GithubRepoRepository,
    private val reposScopeContainer: ReposScopeContainer,
    private val appScreens: AppScreens,
    @Assisted private val userModel: GithubUserModel,
    val it: Any
) : MvpPresenter<ReposView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    override fun onDestroy() {
        reposScopeContainer.destroyRepoSubcomponent()
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun loadData() {
        compositeDisposable += repo.getRepos(userModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                {
                    viewState.showRepos(it)
                    viewState.hideLoading()
                }, {

                    viewState.hideLoading()
                }
            )
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

    private operator fun CompositeDisposable.plusAssign(subscribe: Unit) {

    }

    private fun Unit.subscribe(any: Any, function: () -> Unit) {

    }

    private fun Unit.doOnSubscribe(function: () -> Unit) {

    }

    private fun Any.observeOn(mainThread: Scheduler?) {

    }

    private fun Unit.subscribeOn(io: Scheduler) {

    }


@AssistedFactory
interface ReposPresenterFactory {

    fun presenter(userModel: GithubUserModel): ReposPresenter
}