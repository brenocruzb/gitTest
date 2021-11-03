package com.example.testapplication.data.mappers

import com.example.testapplication.data.model.CatDataResponse
import com.example.testapplication.entity.model.CatData

object CatMapper {
    fun convertToEntity(response: CatDataResponse): CatData =
        CatData(
            fact = response.fact ?: "",
            length = response.length ?: 0
        )
}