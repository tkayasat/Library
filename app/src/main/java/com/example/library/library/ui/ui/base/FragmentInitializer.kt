package com.example.library.library.ui.ui.base

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import java.io.Serializable

interface InitParams : Serializable

abstract class FragmentInitializer<T : InitParams> {

    fun newInstance(initParams: T): Fragment {
        val declaredClassName = this::class.java.declaringClass?.name!!
        val fragment = FragmentFactory().instantiate(
            this::class.java.declaringClass?.classLoader!!,
            declaredClassName
        )

        return fragment.apply {
            arguments = bundleOf(
                declaredClassName to initParams
            )
        }
    }
}

@Suppress("UNCHECKED_CAST")
fun <T : InitParams> Fragment.initParams(): Lazy<T> = lazy {
    requireArguments().getSerializable(this::class.java.name) as T
}