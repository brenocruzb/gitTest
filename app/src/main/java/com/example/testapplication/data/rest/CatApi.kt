package com.example.testapplication.data.rest

import com.example.testapplication.data.model.CatDataResponse
import com.example.testapplication.data.model.CatsDataResponse
import retrofit2.http.GET

interface CatApi {
    @GET("fact")
    suspend fun getCat(): CatDataResponse

    @GET("facts")
    suspend fun getCats(): CatsDataResponse
}