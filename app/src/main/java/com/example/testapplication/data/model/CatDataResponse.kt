package com.example.testapplication.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatDataResponse(
    @SerialName("fact") val fact : String? = null,
    @SerialName("length") val length : Int? = null,
)