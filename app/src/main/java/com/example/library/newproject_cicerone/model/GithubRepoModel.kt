package com.example.library.newproject_cicerone.model

import com.google.gson.annotations.Expose

data class GithubRepoModel(
    @Expose
    val id: String,
    @Expose
    val name: String,
    @Expose
    val userId: String,
    @Expose
    val forksCount: Int,
)