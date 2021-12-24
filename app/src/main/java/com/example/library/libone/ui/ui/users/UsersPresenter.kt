package com.example.library.libone.ui.ui.users

import com.example.library.libone.di.di.scope.containers.UsersScopeContainer
import com.example.library.libone.model.GithubUserModel
import com.example.library.libone.domain.GithubUsersRepository
import com.example.library.libone.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter @Inject constructor(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
    private val appScreens: AppScreens,
    private val usersScopeContainer: UsersScopeContainer,
) : MvpPresenter<UsersView>() {

    val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()
    }

    private fun loadData() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                { users ->
                    viewState.updateList(users)
                    viewState.hideLoading()
                }, {
                    viewState.hideLoading()

                    //#region  okHttpClient - разобрано
                    /*val okHttpClient= OkHttpClient.Builder().build()
            val request = Request.Builder()
                .url ("http://api.github.com/users")
                .build()
            okHttpClient.newCall(request).enqueue(object: Callback{
                override fun onResponse(call: Call, response: Response) {
                    Log.d ("OkHTTP", "Ответ: ${response.body?.string()}")
                }
                override fun onFailure(call: Call, e: IOException) {
                }
            })*/
                    //#endregion
                }
            )
    }

    fun handleUsers(users: List<GithubUserModel>) {
        viewState.updateList(users)
    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(appScreens.reposScreen(userModel))
    }

    override fun onDestroy() {
        usersScopeContainer.destroyUsersSubcomponent()
        super.onDestroy()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}