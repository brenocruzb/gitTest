package com.example.testapplication.data.rest

import com.example.testapplication.data.mappers.CatMapper
import com.example.testapplication.data.mappers.CatsMapper
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.entity.model.CatsData

class CatRepository(private val catApi: CatApi) {

    suspend fun getCat(): CatData =
        CatMapper.convertToEntity(catApi.getCat())

    suspend fun getCats(): CatsData =
        CatsMapper.convertToEntity(catApi.getCats())
}