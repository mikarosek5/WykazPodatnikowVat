package com.example.network.network_response.bank


import com.squareup.moshi.Json
import javax.security.auth.Subject

data class Result(
    @Json(name = "requestId")
    val requestId: String,
    @Json(name = "subjects")
    val subjects: List<Subject>
)