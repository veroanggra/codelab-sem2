package com.veronica.idn.cityweather.network

import com.veronica.idn.cityweather.model.DailyResponse
import com.veronica.idn.cityweather.model.ForecastResponse
import com.veronica.idn.cityweather.model.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather?")
    fun getWetherByGPS(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("units") units: String,
    ): Single<WeatherResponse>

    @GET("forecast?")
    fun getForeCastByGPS(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("units") units: String,
    ): Single<ForecastResponse>

    @GET("find?")
    fun getCityDailyWeatherByGPS(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("cnt") cnt: String,
        @Query("units") units: String,
    ): Single<DailyResponse>
}