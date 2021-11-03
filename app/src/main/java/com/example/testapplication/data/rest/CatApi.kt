package com.example.testapplication.data.rest

import com.example.testapplication.data.model.CatDataResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("fact")
    fun getCat(): Observable<CatDataResponse>
}