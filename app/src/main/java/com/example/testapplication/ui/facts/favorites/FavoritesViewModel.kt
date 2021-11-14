package com.example.testapplication.ui.facts.favorites

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.local.LocalFactManager
import com.example.testapplication.entity.model.CatData
import io.reactivex.Observable

class FavoritesViewModel(private val localFacts: LocalFactManager): ViewModel() {
    fun loadLocalCats(): Observable<List<String>> {
        return Observable.create { emitter ->
            if (localFacts.hasFacts) {
                emitter.onNext(localFacts.getFacts())
            } else {
                emitter.onNext(listOf())
            }
            emitter.onComplete()
        }
    }
}