package com.example.enfecdemo.api

import com.example.enfecdemo.database.model.Users
import retrofit2.http.GET

interface RestEndPoints {

    @GET("users")
    suspend fun getUsersList(): List<Users>

}