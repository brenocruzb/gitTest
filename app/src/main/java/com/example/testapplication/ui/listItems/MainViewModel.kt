package com.example.testapplication.ui.listItems

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.model.Cat
import com.example.testapplication.data.rest.CatRepository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val catRepository: CatRepository): ViewModel() {

    fun loadCats(size: Int): Observable<List<Cat>>{
        return catRepository.getCats(size)
    }

    override fun onCleared() {
        super.onCleared()
    }
}