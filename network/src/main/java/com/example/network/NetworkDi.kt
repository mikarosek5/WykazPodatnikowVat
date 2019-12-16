package com.example.network

import com.example.network.network_source.NetworkSource
import com.example.network.network_source.NetworkSourceImpl
import com.example.network.service.TaxpayerList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { moshiConverter() }
    single { clientHttp() }
    single { retrofit(get(),get()) }
    single { NetworkSourceImpl(get()) as NetworkSource }
}

private fun moshiConverter():MoshiConverterFactory =
    MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build())


private fun clientHttp() = OkHttpClient.Builder().build()
private fun retrofit(httpClient: OkHttpClient,jsonConverter:MoshiConverterFactory) =
    Retrofit.Builder()
        .baseUrl("https://wl-test.mf.gov.pl/")
//        .baseUrl("http://localhost:8080/")
        .addConverterFactory(jsonConverter)
        .client(httpClient)
        .build()
        .create(TaxpayerList::class.java)