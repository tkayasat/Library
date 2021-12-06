package com.example.library.newproject_cicerone.ui.ui.users

import androidx.appcompat.view.menu.MenuView

interface UsersItemView: MenuView.ItemView {
    fun setLogin (login: String)
    fun getLogin(): String
}