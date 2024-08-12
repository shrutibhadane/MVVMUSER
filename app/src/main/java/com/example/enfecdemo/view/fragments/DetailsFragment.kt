package com.example.enfecdemo.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.enfecdemo.R
import com.example.enfecdemo.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        val bundle = arguments
        var userID = bundle?.getInt("USER_ID")
//        var name = bundle?.getInt("name")
        var userName = bundle?.getString("USER_NAME")
//        var email = bundle?.getInt("email")

        binding.textViewId.text = "ID: " + userID.toString()
//        binding.textViewName.text = "Name: " +name.toString()
        binding.textViewUserName.text = "Username: " + userName.toString()
//        binding.textViewEmail.text = "Email: " + email.toString()


    }

}