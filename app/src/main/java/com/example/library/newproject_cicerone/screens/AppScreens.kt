package com.example.library.newproject_cicerone.screens

import com.example.library.newproject_cicerone.ui.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen


object AppScreens {
    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userDetailScreen (userId: String) = FragmentScreen {
        UsersFragment()
    }
}