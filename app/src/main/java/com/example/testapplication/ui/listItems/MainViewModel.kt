package com.example.testapplication.ui.listItems

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.model.CatDataResponse
import com.example.testapplication.data.rest.CatRepository
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.entity.model.CatsData
import io.reactivex.Observable

class MainViewModel(private val catRepository: CatRepository): ViewModel() {

    fun loadCat(): Observable<CatData> {
        return catRepository.getCat()
    }

    fun loadCats(): Observable<CatsData>{
        return catRepository.getCats()
    }

    override fun onCleared() {
        super.onCleared()
    }
}