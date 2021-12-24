package com.example.library.library.ui.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import com.example.library.databinding.FragmentUsersBinding
import com.example.library.library.ui.ui.imageloading.GlideImageLoader
import com.example.library.library.model.GithubUserModel
import com.example.library.library.remote.connectivity.NetworkStatus
import com.example.library.library.ui.ui.App
import com.example.library.library.ui.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

abstract class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    private val presenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.appComponent.inject()
        }

    }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(
            presenter::onUserClicked,
            GlideImageLoader()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showError(err: Throwable) {
        Toast.makeText(requireContext(), err.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun init() {
    }

    override fun showLoading() {
        binding.loadingView.isVisible = true

    }

    override fun hideLoading() {
        binding.loadingView.isVisible = false

    }

    override fun updateList(users: List<GithubUserModel>) {
        adapter.submitList(adapter.currentList + users)
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}