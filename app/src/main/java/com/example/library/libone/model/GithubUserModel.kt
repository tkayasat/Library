package com.example.library.libone.model

import com.google.gson.annotations.Expose


data class GithubUserModel(
    @Expose
    val id: String,

    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,

    @Expose
    val reposUrl: String,
)