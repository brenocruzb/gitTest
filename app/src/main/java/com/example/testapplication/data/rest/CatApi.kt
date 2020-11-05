package com.example.testapplication.data.rest

import com.example.testapplication.data.model.Cat
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("facts/random")
    fun listCats(@Query("amount") amount: Int): Observable<List<Cat>>
}