package com.example.library.libone.ui.ui.users.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.library.databinding.FragmentUsersBinding
import moxy.MvpAppCompatFragment

class UsersInfoFragment : MvpAppCompatFragment() {

    companion object {
        private const val KEY_USER = "KEY"

    }

    private val userId: Int? by lazy {
        arguments?.getInt(KEY_USER, 0)
    }

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root


    fun showLogin(text: String) {
        vb?.tvLogin?.text = text
    }
}