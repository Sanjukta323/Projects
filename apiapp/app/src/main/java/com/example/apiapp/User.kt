package com.example.apiapp

data class User(
    val device: Device,
    val message: String,
    val status: Int,
    val statusDes: String
)