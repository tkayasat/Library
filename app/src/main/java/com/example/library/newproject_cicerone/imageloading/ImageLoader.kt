package com.example.library.newproject_cicerone.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}