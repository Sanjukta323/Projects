package com.example.apipractice

class User : ArrayList<UserItem>()

data class UserResponse(val code :Int?, val meta: String?, val data : User?)

