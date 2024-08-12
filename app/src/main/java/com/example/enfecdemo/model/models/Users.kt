package com.example.enfecdemo.model.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users_table")
data class Users(

    @Expose
    @PrimaryKey
    var id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("username")
    @Expose
    val username: String,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("address")
    @Expose
    val address: Address? = null,

    @SerializedName("phone")
    @Expose
    val phone: String,

    @SerializedName("website")
    @Expose
    val website: String,

    @SerializedName("company")
    @Expose
    val company: Company? = null,
)