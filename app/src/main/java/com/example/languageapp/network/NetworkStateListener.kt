package com.example.languageapp.network

interface NetworkStateListener {
    fun onNetworkConnected()
    fun onNetworkDisconnected()
}