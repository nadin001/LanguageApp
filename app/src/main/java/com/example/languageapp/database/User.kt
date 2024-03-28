package com.example.languageapp.database

data class User (
    val photoUrl: String? = null,
    var firstName: String,
    var secondName: String,
    var points: Double,
)