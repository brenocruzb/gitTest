package com.example.testapplication.ui.facts.favorites

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.local.LocalFactManager

class FavoritesViewModel(private val localFacts: LocalFactManager): ViewModel() {
    fun loadLocalCats(): List<String> = if (localFacts.hasFacts) localFacts.getFacts() else listOf<String>()
}