package com.veronica.idn.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvPopularItemResponse(
    @SerializedName("poster_path")
    val poster_path:String,

    @SerializedName("name")
    val name:String,

    @SerializedName("popularity")
    val popularity:Double,

    @SerializedName("original_language")
    val original_language:String

)
