package com.example.apiapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apiapp.Constant.BASE_URL
import com.example.apiapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding ?= null
    var message : String = ""
    var status : String = ""
    var statusDes : String = ""
    var device : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        val url = BASE_URL
        binding?.btn?.setOnClickListener() {
            Constant.userName = binding?.username?.text.toString().trim()
            Constant.deviecSlNo = binding?.deviceslno?.text.toString().trim()
            CoroutineScope(Dispatchers.Main).launch {
                getDeviceMapping(this@MainActivity)
            }
        }


    }

    private suspend fun getDeviceMapping(activity: Activity) {
        try {
            Log.e("tAG", "getDeviceMapping: URl ${Constant.BASE_URL}")
            val apiService = RetrofitInstance.getRetrofitInstance(Constant.BASE_URL).create(UserService::class.java)
            val response: Response<User> =
                apiService.deviceMapping(
                    userName = Constant.userName,
                    deviceSlNo = Constant.deviecSlNo
                )

            CoroutineScope(Dispatchers.Main).launch {
                if (response.isSuccessful) {
                    val mappingResponse = response.body()
                    message = mappingResponse?.message.toString()
                    status = mappingResponse?.status.toString()
                    statusDes = mappingResponse?.statusDes.toString()
                    device = mappingResponse?.device.toString()

                    Toast.makeText(
                        this@MainActivity,
                        response.body()?.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("tAG", "Response $response")
                } else {
                    // Handle failure response

                    Log.d("tAG", "Unexpected Error: ${response.body()?.message}")
                }

            }
        } catch (e: HttpException) {
            // Handle HTTP errors (non-2xx status codes)
            val responseCode = e.code()
            val errorMessage = e.message()
            // Handle specific HTTP error codes if needed
            if (responseCode == 404) {
                // Handle 404 Not Found
            } else if (responseCode == 500) {
                // Handle 500 Internal Server Error
                Log.e("tAG", "getDeviceMapping: $responseCode")
            }
            // Handle error response accordingly
            Toast.makeText(
                this@MainActivity,
                "Error Code: $responseCode\n$errorMessage",
                Toast.LENGTH_SHORT
            ).show()

            Log.d("tAG", "HTTP Error Response Code: $responseCode, Message: $errorMessage")
        }

    }
}