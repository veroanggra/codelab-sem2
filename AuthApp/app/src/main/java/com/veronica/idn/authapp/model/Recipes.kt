package com.veronica.idn.authapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipes(
    var recipeId: String = "0",
    var recipeName: String? = null,
    var recipeJenis: String? = null
) : Parcelable