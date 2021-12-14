package com.example.library.newproject_cicerone.HW5.info

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.Creator
import com.github.terrakok.cicerone.androidx.FragmentScreen


class RepoScreen(private val url: String,
                 key: String?,
                 fragmentCreator: Creator<FragmentFactory, Fragment>
) : FragmentScreen(key, fragmentCreator) {

}