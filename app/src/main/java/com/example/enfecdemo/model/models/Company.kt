package com.example.enfecdemo.model.database.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Company(

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("catchPhrase")
    @Expose
    val catchPhrase: String,

    @SerializedName("bs")
    @Expose
    val bs: String,

)
