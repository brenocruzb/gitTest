package com.example.testapplication.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Cat(
    @SerializedName("used") val used : Boolean,
    @SerializedName("source") val source : String,
    @SerializedName("type") val type : String,
    @SerializedName("deleted") val deleted : Boolean,
    @SerializedName("text") val text : String,
    @SerializedName("status") val status : Status
): Serializable