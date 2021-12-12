package com.example.library.newproject_cicerone.ui.ui.users

import android.util.Log
import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepository
import com.example.library.newproject_cicerone.screens.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import okhttp3.*
import java.io.IOException

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
        val okHttpClient= OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url ("http://api.github.com/users")
            .build()
        okHttpClient.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                Log.d ("OkHTTP", "Ответ: ${response.body?.string()}")
            }
            override fun onFailure(call: Call, e: IOException) {
            }
        })

    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(AppScreens.userDetailScreen(userModel.login))
        router.navigateTo(AppScreens.imageConverter())
    }

    private fun handleUsers(users: List<GithubUserModel>) {
        viewState.updateList()
    }


    fun onDestroy(view: UsersView?) {
        disposables.dispose()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
