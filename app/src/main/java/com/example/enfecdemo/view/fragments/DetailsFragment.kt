package com.example.enfecdemo.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import com.example.enfecdemo.R
import com.example.enfecdemo.databinding.FragmentDetailsBinding
import com.example.enfecdemo.model.database.model.Users
import com.example.enfecdemo.utils.USER_DATA

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        val bundle = arguments
        val userData = bundle?.getParcelable<Users>(USER_DATA)

        binding.textViewId.text = "ID: " + userData?.id.toString()
        binding.textViewName.text = "Name: " +userData?.name.toString()
        binding.textViewUserName.text = "Username: " + userData?.username.toString()
        binding.textViewEmail.text = "Email: " +userData?.email.toString()


    }

}