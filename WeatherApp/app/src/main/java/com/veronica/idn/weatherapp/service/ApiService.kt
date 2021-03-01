package com.veronica.idn.weatherapp.service

import android.telecom.Call
import com.veronica.idn.weatherapp.model.ResponseWeather
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET ("weather?")
    fun getWeather(
        @Query("q") name : String?,
        @Query("appid") apikey : String?
    ):retrofit2.Call<ResponseWeather>
}