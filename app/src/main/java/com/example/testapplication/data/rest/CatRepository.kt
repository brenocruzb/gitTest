package com.example.testapplication.data.rest

import com.example.testapplication.data.mappers.CatMapper
import com.example.testapplication.data.model.CatDataResponse
import com.example.testapplication.entity.model.CatData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CatRepository(private val catApi: CatApi) {
    fun getCat(): Observable<CatData> {
        return catApi.getCat().map {
            CatMapper.convertToEntity(it)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}