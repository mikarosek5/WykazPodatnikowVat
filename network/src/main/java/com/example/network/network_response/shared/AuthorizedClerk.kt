package com.example.network.network_response.shared


import com.squareup.moshi.Json

data class AuthorizedClerk(
    @Json(name = "companyName")
    val companyName: String,
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "nip")
    val nip: String,
    @Json(name = "pesel")
    val pesel: Any
)