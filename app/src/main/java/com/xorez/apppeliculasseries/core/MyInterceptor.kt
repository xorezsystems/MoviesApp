package com.xorez.apppeliculasseries.core

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            //.addHeader("x-rapidapi-key", "d3fe3a34c5mshf70e1bb90c464a8p1ba4aajsn4233972e8a9c")
            //.addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}