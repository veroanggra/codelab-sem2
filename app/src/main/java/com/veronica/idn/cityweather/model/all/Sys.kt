package com.veronica.idn.cityweather.model.all

import com.google.gson.annotations.SerializedName

data class Sys(
    @field:SerializedName("pod")
    val pod: String? = null
)