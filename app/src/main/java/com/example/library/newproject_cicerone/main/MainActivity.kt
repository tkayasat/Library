package com.example.library.newproject_cicerone.main

import com.example.library.R
import com.example.library.moxy.MainPresenter
import com.example.library.moxy.MainView
import com.example.library.newproject_cicerone.ui.ui.App
import com.example.library.newproject_cicerone.ui.ui.base.BackButtonListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

abstract class MainActivity : MvpAppCompatActivity(R.layout.main_activity_cicerone), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {

        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backPressed()
    }
}