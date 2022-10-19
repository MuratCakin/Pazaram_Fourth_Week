package com.muratcakin.weatherapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    @SerializedName("current")
    val current: Current?,
    @SerializedName("daily")
    val daily: List<Daily>?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
) : Parcelable