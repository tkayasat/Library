package com.example.library.newproject_cicerone.ui.ui.users

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

class UsersView {
    interface UsersView : MvpView {

        @AddToEndSingle
        fun updateList()
    }
}