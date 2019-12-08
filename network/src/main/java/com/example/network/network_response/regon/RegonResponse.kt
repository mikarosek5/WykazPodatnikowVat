package com.example.network.network_response.regon


import com.squareup.moshi.Json

data class RegonResponse(
    @Json(name = "result")
    val result: Result
)