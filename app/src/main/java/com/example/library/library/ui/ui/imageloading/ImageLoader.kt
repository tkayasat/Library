package com.example.library.library.ui.ui.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}