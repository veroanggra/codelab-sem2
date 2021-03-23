package com.veronica.idn.moviecatalogue.network

import android.telecom.Call
import com.veronica.idn.moviecatalogue.model.UpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Query
import com.veronica.idn.moviecatalogue.model.PopularResponse as PopularResponse

interface ApiService {
    @GET("/movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<PopularResponse>

    @GET("/movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<UpcomingResponse>

}