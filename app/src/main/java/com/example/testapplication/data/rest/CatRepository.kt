package com.example.testapplication.data.rest

import com.example.testapplication.data.model.Cat
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CatRepository(private val catApi: CatApi) {
    fun getCats(size: Int): Observable<List<Cat>> {
        return catApi.listCats(size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}