package com.muratcakin.weatherapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Daily(
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("temp")
    val temp: Temp?,
    @SerializedName("weather")
    val weather: List<Weather>?
) : Parcelable
