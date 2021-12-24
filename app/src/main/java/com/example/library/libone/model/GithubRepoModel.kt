package com.example.library.libone.model

import com.example.library.libone.ui.ui.base.InitParams
import com.google.gson.annotations.Expose

data class GithubRepoModel(
    @Expose
    val id: String,
    @Expose
    val name: String,
    @Expose
    val owner: GithubRepoOwner,
    @Expose
    val forksCount: Int,
) : InitParams

data class GithubRepoOwner(
    @Expose
    val id: String,
)