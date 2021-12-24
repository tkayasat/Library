package com.example.library.libone.ui.ui.users

import androidx.appcompat.view.menu.MenuView

interface UsersItemView: MenuView.ItemView {
    fun setLogin (login: String)
    fun getLogin(): String
}