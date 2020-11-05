package com.example.testapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Status(
    @SerializedName("verified") val verified : Boolean,
    @SerializedName("sentCount") val sentCount : Int
): Serializable