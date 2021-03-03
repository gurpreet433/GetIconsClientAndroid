package com.gurpreet.singh.app.network

import okhttp3.Interceptor
import okhttp3.Response

class IconsInterceptor : Interceptor {

    //This adds the token to the header.



    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer " + "X0vjEUN6KRlxbp2DoUkyHeM0VOmxY91rA6BbU5j3Xu6wDodwS0McmilLPBWDUcJ1")
            .build()

        return chain.proceed(request)
    }
}