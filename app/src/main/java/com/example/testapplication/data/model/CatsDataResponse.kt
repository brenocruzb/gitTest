package com.example.testapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CatsDataResponse(
    @SerializedName("current_page") val currentPage : Int? = null,
    @SerializedName("data") val data : List<CatDataResponse>? = null,
    @SerializedName("total") val total : Int? = null,
    @SerializedName("last_page") val lastPage : Int? = null,
): Serializable