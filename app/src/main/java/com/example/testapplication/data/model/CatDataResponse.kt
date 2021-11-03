package com.example.testapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CatDataResponse(
    @SerializedName("fact") val fact : String? = null,
    @SerializedName("length") val length : Int? = null,
): Serializable