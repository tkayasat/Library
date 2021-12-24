package com.example.library.library.ui.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    ViewBindingDelegate(T::class.java, this)

class ViewBindingDelegate<T>(
    bindingClass: Class<T>,
    private val fragment: Fragment
) : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver() {

    private var binding: T? = null

    private val bindMethod = bindingClass.getMethod("bind", View::class.java)

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        if (binding != null) {
            return binding!!
        }

        fragment.lifecycle.addObserver(this)

        val lifecycle = this.fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Неверное состояние вью: ${lifecycle.currentState}")
        }

        binding = bindMethod(null, thisRef.requireView()) as T
        return binding!!
    }

    fun onCreate(owner: LifecycleOwner) {
        fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->
            viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver() {
                fun onDestroy(owner: LifecycleOwner) {
                    binding = null
                }
            })
        }
    }
}

private fun Lifecycle.addObserver(defaultLifecycleObserver: DefaultLifecycleObserver) {

}

open class DefaultLifecycleObserver {

}
