package com.example.library.newproject_cicerone.navigation

import ImageConverter.main.ImageConverterFragment
import androidx.fragment.app.FragmentFactory
import com.example.library.newproject_cicerone.HW5.info.RepoFragment
import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.ui.ui.users.UsersFragment
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