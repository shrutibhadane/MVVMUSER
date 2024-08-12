package com.example.enfecdemo.model.database.converters

import androidx.room.TypeConverter
import com.example.enfecdemo.model.database.model.Address
import com.example.enfecdemo.model.database.model.Company
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Type converters for converting Address and Company objects to and from JSON strings.
 */
class Converters {

    /**
     * Converts an Address object to a JSON string.
     * @param address The Address object to convert.
     * @return The JSON string representation of the Address object.
     */
    @TypeConverter
    fun fromAddress(address: Address?): String? {
        return if (address == null) null else Gson().toJson(address)
    }

    /**
     * Converts a JSON string to an Address object.
     * @param addressString The JSON string to convert.
     * @return The Address object parsed from the JSON string.
     */
    @TypeConverter
    fun toAddress(addressString: String?): Address? {
        return if (addressString == null) null else Gson().fromJson(addressString, object : TypeToken<Address>() {}.type)
    }

    /**
     * Converts a Company object to a JSON string.
     * @param company The Company object to convert.
     * @return The JSON string representation of the Company object.
     */
    @TypeConverter
    fun fromCompany(company: Company?): String? {
        return if (company == null) null else Gson().toJson(company)
    }

    /**
     * Converts a JSON string to a Company object.
     * @param companyString The JSON string to convert.
     * @return The Company object parsed from the JSON string.
     */
    @TypeConverter
    fun toCompany(companyString: String?): Company? {
        return if (companyString == null) null else Gson().fromJson(companyString, object : TypeToken<Company>() {}.type)
    }
}