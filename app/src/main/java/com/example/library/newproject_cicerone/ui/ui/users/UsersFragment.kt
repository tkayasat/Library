package com.example.library.newproject_cicerone.ui.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.library.databinding.FragmentUsersBinding
import com.example.library.newproject_cicerone.connectivity.NetworkStatus
import com.example.library.newproject_cicerone.imageloading.GlideImageLoader
import com.example.library.newproject_cicerone.model.GithubUserModel
import com.example.library.newproject_cicerone.model.domain.GithubUsersRepositoryImpl
import com.example.library.newproject_cicerone.remote.ApiHolder
import com.example.library.newproject_cicerone.ui.ui.App
import com.example.library.newproject_cicerone.ui.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

        private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    private val presenter by moxyPresenter {
        UsersPresenter(
            App.instance.router,
            GithubUsersRepositoryImpl(ApiHolder.retrofitService)
        )
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(presenter::onUserClicked,
        GlideImageLoader())
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