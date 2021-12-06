package com.example.library.newproject_cicerone.main

import com.example.library.newproject_cicerone.screens.AppScreens
import com.example.library.newproject_cicerone.ui.ui.base.BackButtonListener
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val screens: AppScreens) :
    MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.usersScreen())
    }

    fun backClicked() {
        router.exit()
    }

    fun backPressed() {
    }
}