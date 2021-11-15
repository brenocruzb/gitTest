package com.example.testapplication.ui.facts.list

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.rest.CatRepository
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.entity.model.CatsData
import com.example.testapplication.utils.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class MainViewModel(private val catRepository: CatRepository) : ViewModel() {

    fun loadCat(): Flow<Results<CatData>> {
        return flow { emit(Results.success(catRepository.getCat())) }
            .onStart { emit(Results.loading()) }
            .onCompletion { emit(Results.done()) }
            .catch { ex -> emit(Results.error(ex)) }
            .flowOn(Dispatchers.Default)
    }

    fun loadCats(): Flow<Results<CatsData>> {
        return flow { emit(Results.success(catRepository.getCats())) }
            .onStart { emit(Results.loading()) }
            .onCompletion { emit(Results.done()) }
            .catch { ex -> emit(Results.error(ex)) }
            .flowOn(Dispatchers.Default)
    }
}