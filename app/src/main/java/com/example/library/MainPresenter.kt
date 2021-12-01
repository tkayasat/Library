package com.example.library

import moxy.MvpPresenter

class MainPresenter : MvpPresenter<MainView>() {

    private val model = CountersModel()

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
}