package com.veronica.idn.moviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularResponse(
	val page: Int? = null,
	val totalPages: Int? = null,
	val results: List<ResultsItem?>? = null,
	val totalResults: Int? = null
) : Parcelable


