package com.veronica.idn.cityweather.network

import com.veronica.idn.cityweather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("appid", BuildConfig.API_KEY)
            .build()

        val request = originalRequest.newBuilder().url(url).build()

        return chain.proceed(request)

    }

}
