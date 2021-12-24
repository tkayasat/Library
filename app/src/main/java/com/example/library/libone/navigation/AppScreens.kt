package com.example.library.libone.navigation

import ImageConverter.main.ImageConverterFragment
import androidx.fragment.app.FragmentFactory
import com.example.library.libone.info.RepoFragment
import com.example.library.libone.model.GithubUserModel
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


interface AppScreens {
    fun usersScreen() : FragmentScreen

    fun  reposScreen(userModel: GithubUserModel): FragmentScreen
    abstract fun FragmentScreen(fragmentCreator: (argument: FragmentFactory) -> Unit): FragmentScreen
}

abstract class AppScreensImpl : AppScreens {

    override fun reposScreen(userModel: GithubUserModel) = FragmentScreen {
        RepoFragment.newInstance(userModel)
    }

    fun imageConverter(): Screen =
        FragmentScreen { ImageConverterFragment() }
}