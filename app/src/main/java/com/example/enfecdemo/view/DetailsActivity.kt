package com.example.enfecdemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.enfecdemo.R
import com.example.enfecdemo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


       /* val bundle = arguments
        var userID = bundle?.getInt("id")
        var name = bundle?.getInt("name")
        var userName = bundle?.getInt("username")
        var email = bundle?.getInt("email")

        binding.textViewId.text = "ID: " + userID.toString()
        binding.textViewName.text = "Name: " +name.toString()
        binding.textViewUserName.text = "Username: " + userName.toString()
        binding.textViewEmail.text = "Email: " + email.toString()*/

    }
}