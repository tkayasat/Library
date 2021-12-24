package com.example.library.libone.ui.ui.repodetails

import com.example.library.R
import com.example.library.databinding.FragmentRepoDetailsBinding
import com.example.library.libone.model.GithubRepoModel
import com.example.library.libone.ui.ui.base.FragmentInitializer
import com.example.library.libone.ui.ui.base.initParams
import com.example.library.libone.ui.ui.base.viewBinding
import com.example.library.libone.ui.ui.users.RepoDetailsPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoDetailsFragment : MvpAppCompatFragment(R.layout.fragment_repo_details), RepoDetailsView {

    private val binding by viewBinding<FragmentRepoDetailsBinding>()

    private val presenter by moxyPresenter {
        RepoDetailsPresenter(repoModel)
    }

    private val repoModel by initParams<GithubRepoModel>()

    override fun showRepoDetails(repoModel: GithubRepoModel) {
        binding.forksCountTextView.text = "Количество форков: ${repoModel.forksCount}"
    }

    companion object : FragmentInitializer<GithubRepoModel>()
}