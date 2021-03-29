package com.veronica.idn.moviecatalogue.model.movie

import com.google.gson.annotations.SerializedName

data class MovieUpcomingItemResponse(
    @SerializedName("page")
    val page:Int,
    @SerializedName("results")
    val result: ArrayList<UpcomingResponse>
)
