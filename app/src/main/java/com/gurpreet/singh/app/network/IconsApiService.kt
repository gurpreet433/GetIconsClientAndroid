package com.gurpreet.singh.app.network

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

private const val BASE_URL = "https://api.iconfinder.com/"

private val client = OkHttpClient.Builder().apply {
    addInterceptor(IconsInterceptor())
}.build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .client(client)
    .baseUrl(BASE_URL)
    .build()

interface IconsApiService {

    @GET("v4/iconsets")
    fun getIconSets(@QueryMap params: Map<String, String>): Call<String>
}

object IconsApi {
    val retrofitService: IconsApiService by lazy {
        retrofit.create(IconsApiService::class.java)
    }
}