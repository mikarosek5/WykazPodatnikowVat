package com.example.network.network_response.bank


import com.squareup.moshi.Json

data class BankAccountResponse(
    @Json(name = "result")
    val result: Result
)