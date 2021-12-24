package com.example.library.library.ui.ui.users.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.library.databinding.FragmentUsersBinding
import com.example.library.library.domain.GithubUsersRepository
import com.example.library.library.ui.ui.App
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

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