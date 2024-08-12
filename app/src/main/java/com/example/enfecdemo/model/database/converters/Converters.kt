package com.example.enfecdemo.model.database.converters

import androidx.room.TypeConverter
import com.example.enfecdemo.model.database.model.Address
import com.example.enfecdemo.model.database.model.Company
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromAddress(address: Address?): String? {
        return if (address == null) null else Gson().toJson(address)
    }

    @TypeConverter
    fun toAddress(addressString: String?): Address? {
        return if (addressString == null) null else Gson().fromJson(addressString, object : TypeToken<Address>() {}.type)
    }

    @TypeConverter
    fun fromCompany(company: Company?): String? {
        return if (company == null) null else Gson().toJson(company)
    }

    @TypeConverter
    fun toCompany(companyString: String?): Company? {
        return if (companyString == null) null else Gson().fromJson(companyString, object : TypeToken<Company>() {}.type)
    }
}