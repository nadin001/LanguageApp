package com.example.languageapp.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.net.ConnectivityManager

class NetworkReceiver : BroadcastReceiver() {
    private val listeners = mutableListOf<NetworkStateListener>()
    override fun onReceive(context: Context?, intent: Intent?) =
        if (isNetworkConnected(context)) listeners.forEach { it.onNetworkConnected() }
        else listeners.forEach { it.onNetworkDisconnected() }

    fun addListener(listener: NetworkStateListener) {
        listeners.add(listener)
    }

    private fun isNetworkConnected(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager?.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}