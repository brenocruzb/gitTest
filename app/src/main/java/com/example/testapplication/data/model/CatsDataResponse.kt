package com.example.testapplication.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatsDataResponse(
    @SerialName("current_page") val currentPage : Int? = null,
    @SerialName("data") val data : List<CatDataResponse>? = null,
    @SerialName("total") val total : Int? = null,
    @SerialName("last_page") val lastPage : Int? = null,
)