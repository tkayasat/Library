package com.example.library.newproject_cicerone.remote.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.core.content.getSystemService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject


class NetworkStatus(context: Context) {

    private val networkSubject: PublishSubject<Boolean> = PublishSubject.create()

    private val connectivityManager = context.getSystemService<ConnectivityManager>()

    fun getNetworkSubject(): Observable<Boolean> {
        return networkSubject
    }

    init {
        val request = NetworkRequest.Builder().build()

        connectivityManager?.registerNetworkCallback(
            request,
            object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    networkSubject.onNext(true)
                }

                override fun onLost(network: Network) {
                    networkSubject.onNext(false)
                }


                override fun onUnavailable() {
                    networkSubject.onNext(false)
                }
            })
    }
}