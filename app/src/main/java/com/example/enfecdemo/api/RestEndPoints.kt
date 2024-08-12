package com.example.enfecdemo.api

import com.example.enfecdemo.model.database.model.Users
import retrofit2.http.GET

/**
 * RestEndPoints interface defines the REST API endpoints for the application.
 * This interface uses Retrofit annotations to define the HTTP methods and endpoints.
 */
interface RestEndPoints {

    /**
     * Retrieves a list of users from the server.
     *
     * @return A list of Users objects.
     */
    @GET("users")
    suspend fun getUsersList(): List<Users>

}