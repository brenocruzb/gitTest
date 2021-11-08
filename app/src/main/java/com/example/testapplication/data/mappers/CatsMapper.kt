package com.example.testapplication.data.mappers

import com.example.testapplication.data.model.CatsDataResponse
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.entity.model.CatsData

object CatsMapper {
    fun convertToEntity(response: CatsDataResponse): CatsData =
        CatsData(
            currentPage = response.currentPage ?: 0,
            data = response.data?.map { CatData(
                fact = it.fact ?: "",
                length = it.length ?: 0
            )} ?: listOf(),
            total = response.total ?: 0,
            lastPage = response.lastPage ?: 0
        )
}