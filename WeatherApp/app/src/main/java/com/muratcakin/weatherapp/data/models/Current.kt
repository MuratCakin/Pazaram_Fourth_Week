package com.muratcakin.weatherapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Current(
    @SerializedName("temp")
    val temp: Double?,
    @SerializedName("weather")
    val weather: List<Weather>?
) : Parcelable
