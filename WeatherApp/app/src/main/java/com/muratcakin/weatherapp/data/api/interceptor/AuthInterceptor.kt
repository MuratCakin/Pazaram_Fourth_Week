package com.muratcakin.weatherapp.data.api.interceptor

import com.muratcakin.weatherapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val apiKeyRequest = originalRequest
            .newBuilder()
            .header("X-Api-Key", BuildConfig.API_KEY) // to authorize with api key as header
            .build()

        return chain.proceed(apiKeyRequest)
    }
}