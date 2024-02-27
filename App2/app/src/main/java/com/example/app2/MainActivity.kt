package com.example.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating variables to store name
        val et :EditText = findViewById(R.id.editTextText)
        val ett = findViewById<EditText>(R.id.editTextText)

        //taking input for name
        val edTextIn :String = et.text.toString()

        //var for email
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)

        //taking input for email
        val emIn = email.text.toString()

       //var for phone
        val ph = findViewById<EditText>(R.id.editTextPhone)

        //taking phone no input
        val phIn = ph.text

       //button
        val btn : Button = findViewById(R.id.confirm_button)
        btn.setOnClickListener(){
            Toast.makeText(this@MainActivity,"Button is clicked",Toast.LENGTH_LONG).show()
        }

        



    }
}