package com.example.library.library.ui.ui.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface MainView : MvpView {
    fun setButtonText (index:Int, text: String)
}