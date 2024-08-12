package com.example.enfecdemo.api

import com.example.enfecdemo.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton class responsible for providing a single instance of Retrofit for API calls.
 */
object RetroFitInstance {

    /**
     * Retrofit instance variable.
     */
    private var INSTANCE: Retrofit? = null

    /**
     * Returns the singleton instance of Retrofit.
     * If the instance is null, a new instance is created with the BASE_URL and GsonConverterFactory.
     * @return Retrofit instance
     */
    fun getInstance(): Retrofit = INSTANCE ?: kotlin.run {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}