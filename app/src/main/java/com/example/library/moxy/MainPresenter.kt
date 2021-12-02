package com.example.library.moxy

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val model: Router
) : MvpPresenter<MainView>() {

    fun counterClickFirst() {
        val nextValue = model.increment1()
        viewState.setFirstCounter(nextValue.toString())
    }

    fun counterClickSecond() {
        val nextValue = model.increment1()
        viewState.setSecondCounter(nextValue.toString())
    }

    fun counterClickThird() {
        val nextValue = model.increment1()
        viewState.setThirdCounter(nextValue.toString())
    }

    fun backPressed() {
        TODO("Not yet implemented")
    }
}