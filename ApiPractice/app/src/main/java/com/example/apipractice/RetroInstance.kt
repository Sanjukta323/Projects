package com.example.apipractice

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {

    companion object{
        private const val url = "https://gorest.co.in/public/v2/"

        fun getRetroInstance(): Retrofit {


            return Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

