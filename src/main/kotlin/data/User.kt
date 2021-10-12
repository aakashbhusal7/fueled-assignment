package data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val userName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("address")
    val address: Address,
    @SerializedName("phone")
    val phoneNumber: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("company")
    val company: Company,
    var average:Float?
)

data class Address(
    @SerializedName("street")
    val streetName: String,
    @SerializedName("suite")
    val suiteName: String,
    @SerializedName("city")
    val cityName: String,
    @SerializedName("zipcode")
    val zipCode: String,
    @SerializedName("geo")
    val geoData: GeoData
)

data class GeoData(
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lng")
    val longitude: Double
)

data class Company(
    @SerializedName("name")
    val companyName: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("bs")
    val bs: String
)
