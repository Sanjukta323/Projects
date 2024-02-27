package com.example.apipractice

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetroService {

    @GET("users")
    @Headers("Accept:application/json" ,"Content-Type:application/json","Authorization: Bearer ACCESS-TOKEN","https://gorest.co.in/public/v2/users")
    fun getUserList() : Call<User>

    @GET("users")
    @


    @POST("users")
    @Headers("Accept:application/json" ,"Content-Type:application/json" ,"Authorization: Bearer ACCESS-TOKEN" ,"https://gorest.co.in/public/v2/users")
    fun createUser(@Body params: UserItem) : Call<UserResponse>


}