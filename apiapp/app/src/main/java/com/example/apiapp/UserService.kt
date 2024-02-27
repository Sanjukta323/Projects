package com.example.apiapp

import android.provider.SyncStateContract.Constants
import android.widget.EditText
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Path


interface UserService {

    @POST("mATMV2/updateDevice/{userName}/{deviceSlNo}/")
    suspend fun deviceMapping(
        @Path("userName") userName: String,
        @Path("deviceSlNo") deviceSlNo: String
    ): Response<User>




}




