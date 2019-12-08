package com.example.network.network_response.nip


import com.squareup.moshi.Json

data class NipResponse(
    @Json(name = "result")
    val result: Result
)