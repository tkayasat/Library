package com.example.library

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClickFirst() {
        val nextValue = model.increment1()
        view.setFirstCounter(nextValue.toString())
    }

    fun counterClickSecond() {
        val nextValue = model.increment1()
        view.setSecondCounter(nextValue.toString())
    }

    fun counterClickThird() {
        val nextValue = model.increment1()
        view.setThirdCounter(nextValue.toString())
    }
}