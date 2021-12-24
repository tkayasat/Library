package ImageConverter.main

import ImageConverter.interfaces.MySchedulareFact
import ImageConverter.model.Converter
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.library.databinding.FragmentUsersBinding
import com.example.library.library.ui.ui.App
import com.example.library.library.ui.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ImageConverterFragment : MvpAppCompatFragment(), BackButtonListener {


    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!
    private var imageUri: Uri? = null
    private val presenter: ImageConverterPresenter by moxyPresenter {
        ImageConverterPresenter(
            Converter(requireContext()),
            MySchedulareFact.MySchedulersFact.create(),
            App.instance.router
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = data?.data
            imageUri?.let { presenter.originalImageSelected(it) }
        }
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}