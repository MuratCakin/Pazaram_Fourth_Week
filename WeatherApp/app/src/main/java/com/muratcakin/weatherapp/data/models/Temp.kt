package com.muratcakin.weatherapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Temp(
    @SerializedName("max")
    val max: Double?,
    @SerializedName("min")
    val min: Double?
) : Parcelable