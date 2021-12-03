package com.example.library.newproject_cicerone.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface MainView : MvpView {
    fun setButtonText (index:Int, text: String)
}