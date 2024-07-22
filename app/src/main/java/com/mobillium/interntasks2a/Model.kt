package com.mobillium.interntasks2a

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    val id : Int,
    val city : String,
    val weather_degree : String,
    val degree_range : String,
    val weather : String,
    val image : Int
): Parcelable