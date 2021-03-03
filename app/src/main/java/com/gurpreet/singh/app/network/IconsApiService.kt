package com.gurpreet.singh.app.network

import com.gurpreet.singh.app.data.ServerResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

private const val BASE_URL = "https://api.iconfinder.com/"

private val client = OkHttpClient.Builder().apply {
    addInterceptor(IconsInterceptor())
}.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .baseUrl(BASE_URL)
    .build()

interface IconsApiService {

    @GET("v4/iconsets")
    fun getIconSets(@QueryMap params: Map<String, String>): Call<ServerResponse>
}

object IconsApi {
    val retrofitService: IconsApiService by lazy {
        retrofit.create(IconsApiService::class.java)
    }
}