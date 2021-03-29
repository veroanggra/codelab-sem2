package com.veronica.idn.moviecatalogue.network

import com.veronica.idn.moviecatalogue.model.movie.MovieUpcomingItemResponse
import com.veronica.idn.moviecatalogue.model.movie.PopularResponse
import com.veronica.idn.moviecatalogue.model.movie.UpcomingResponse
import com.veronica.idn.moviecatalogue.model.tv.TVPopularResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<PopularResponse>

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<MovieUpcomingItemResponse>

    @GET("tv/popular")
    fun getTvPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<TVPopularResponse>

}