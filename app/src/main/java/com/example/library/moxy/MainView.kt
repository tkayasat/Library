package com.example.library.moxy

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainView : MvpView {

    @AddToEndSingle
    fun setFirstCounter(text: String)

    @AddToEndSingle
    fun setSecondCounter(text: String)

    @AddToEndSingle
    fun setThirdCounter(text: String)
}