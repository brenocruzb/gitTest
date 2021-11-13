package com.example.testapplication.data.local

import android.content.Context
import java.lang.NullPointerException

class LocalFactManager(context: Context) {
    private val preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    private val facts = "facts"
    val hasFacts get() = this.preferences.contains(this.facts)

    private fun setHashSet(key: String, value: List<String>) {
        val hashSet = HashSet<String>(value)
        val editor = preferences.edit()

        editor.putStringSet(key, hashSet)
        editor.apply()
    }

    fun getFacts(): List<String> {
        return preferences.getStringSet(facts, null)?.toList() ?:
        throw NullPointerException("Facts cannot be null.")
    }

    fun setFacts(facts: List<String>) {
        setHashSet(this.facts, facts)
    }
}