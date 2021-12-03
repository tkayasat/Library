package com.example.library.newproject_cicerone.ui.ui.users

import com.example.library.newproject_cicerone.ui.ui.base.IItemView

interface UsersItemView: IItemView {
    fun setLogin (login: String)
    fun getLogin(): String
}