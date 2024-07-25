package com.mobillium.interntasks2a

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    val id : Int,
    val city : String,
    var weatherDegree : String,
    val degreeRange : String,
    val weather : String,
    val image : Int
): Parcelable