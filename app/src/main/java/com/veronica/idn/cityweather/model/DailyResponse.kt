package com.veronica.idn.cityweather.model

import com.google.gson.annotations.SerializedName

data class DailyResponse(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("cod")
	val cod: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("list")
	val list: List<ListItemd?>? = null
)

data class Coord(

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)

data class ListItemd(

	@field:SerializedName("dt")
	val dt: Int? = null,

	@field:SerializedName("rain")
	val rain: Any? = null,

	@field:SerializedName("coord")
	val coord: Coord? = null,

	@field:SerializedName("snow")
	val snow: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("weather")
	val weather: List<WeatherItemd?>? = null,

	@field:SerializedName("main")
	val main: Main? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("clouds")
	val clouds: Clouds? = null,

	@field:SerializedName("sys")
	val sys: Sys? = null,

	@field:SerializedName("wind")
	val wind: Wind? = null
)

data class Wind(

	@field:SerializedName("deg")
	val deg: Int? = null,

	@field:SerializedName("speed")
	val speed: Double? = null
)

data class Sys(

	@field:SerializedName("country")
	val country: String? = null
)

data class WeatherItemd(

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("main")
	val main: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Main(

	@field:SerializedName("temp")
	val temp: Double? = null,

	@field:SerializedName("temp_min")
	val tempMin: Double? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("pressure")
	val pressure: Int? = null,

	@field:SerializedName("feels_like")
	val feelsLike: Double? = null,

	@field:SerializedName("temp_max")
	val tempMax: Double? = null,

	@field:SerializedName("grnd_level")
	val grndLevel: Int? = null,

	@field:SerializedName("sea_level")
	val seaLevel: Int? = null
)

data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
)
