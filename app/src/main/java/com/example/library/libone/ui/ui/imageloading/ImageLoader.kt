package com.example.library.libone.ui.ui.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}