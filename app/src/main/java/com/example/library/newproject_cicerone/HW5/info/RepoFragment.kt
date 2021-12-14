package com.example.library.newproject_cicerone.HW5.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.Fragment
import com.example.library.R
import com.example.library.databinding.FragmentRepositoryInfoBinding
import com.example.library.databinding.FragmentUsersBinding
import com.example.library.newproject_cicerone.HW5.GithubRepo
import moxy.MvpAppCompatFragment

abstract class RepoFragment : MvpAppCompatFragment(R.layout.fragment_repository_info), ReposView {

    companion object {

        private const val URL = "RepoFragment.url"

        //fun newInstance(url: String) : Fragment = RepoFragment() //ошибка , не сообразить(
        //    .arguments(URL to url)

    }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val url: String by lazy {
        arguments?.getString(URL).orEmpty()
    }

    private var vb: FragmentRepositoryInfoBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentRepositoryInfoBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun showRepo(repos: List<GithubRepo>) {

    }

    override fun init() {

    }

}