package com.example.network.network_response.nip


import com.example.network.network_response.shared.Subject
import com.squareup.moshi.Json

data class Result(
    @Json(name = "requestId")
    val requestId: String,
    @Json(name = "subject")
    val subject: Subject
)