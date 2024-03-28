package com.example.languageapp.database

import android.content.Context.MODE_PRIVATE
import com.example.languageapp.Application

class Storage(
    languageApplication: Application
) {
    private val sharedPref = languageApplication.getSharedPreferences("MyPrefs", MODE_PRIVATE)

    fun saveInt(key: String, value: Int) = with(sharedPref.edit()) {
        putInt(key, value)
        apply()
    }

    fun getInt(key: String): Int = sharedPref.getInt(key, 0)

    fun saveString(key: String, value: String) = with(sharedPref.edit()) {
        putString(key, value)
        apply()
    }
    fun getString(key: String): String = sharedPref.getString(key, null) ?: ""
}