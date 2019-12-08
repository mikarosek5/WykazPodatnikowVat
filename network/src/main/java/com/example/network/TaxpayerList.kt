package com.example.network

import com.example.network.network_response.bank.BankAccountResponse
import com.example.network.network_response.regon.RegonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://wl-test.mf.gov.pl/"

interface TaxpayerList {

    @GET("api/search/bank-account/{accountNumber}")
    suspend fun getInfoByBankAccount(@Path("accountNumber") accountNumber: Long, @Query("date") date: String): BankAccountResponse

    @GET("api/search/regon/{regon}")
    suspend fun getInfoByRegon(@Path("regon") regon: Long, @Query("date") date: String): RegonResponse

    @GET("api/search/nip/{nip}")
    suspend fun getInfoByNip(@Path("nip") regon: Long, @Query("date") date: String): RegonResponse

    //Todo Zmienic date na LocalDate + default


}