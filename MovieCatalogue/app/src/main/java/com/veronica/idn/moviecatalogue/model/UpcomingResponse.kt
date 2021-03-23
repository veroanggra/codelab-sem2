package com.veronica.idn.moviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpcomingResponse(
	val dates: Dates? = null,
	val page: Int? = null,
	val totalPages: Int? = null,
	val results: List<ResultsItem?>? = null,
	val totalResults: Int? = null
) : Parcelable


@Parcelize
data class Dates(
	val maximum: String? = null,
	val minimum: String? = null
) : Parcelable
