package com.example.library.library.ui.ui.main

import com.example.library.library.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter

@Inject constructor(
    private val router: Router,
    private val appScreens: AppScreens,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(appScreens.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}