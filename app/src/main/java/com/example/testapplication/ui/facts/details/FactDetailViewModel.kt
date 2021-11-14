package com.example.testapplication.ui.facts.details

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.local.LocalFactManager
import io.reactivex.Observable
import java.lang.Exception

class FactDetailViewModel(private val localFacts: LocalFactManager): ViewModel() {
    fun addFavorite(fact: String): Observable<String> {
        return Observable.create { emitter ->
            try {
                val list = mutableListOf<String>()
                list.addAll(if (localFacts.hasFacts) localFacts.getFacts() else listOf())
                list.add(fact)
                localFacts.setFacts(list)

                emitter.onNext("Sucesso!")
                emitter.onComplete()
            } catch (ex: Exception) {
                emitter.onError(ex)
                emitter.onComplete()
            }
        }

    }
}