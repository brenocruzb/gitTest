package com.example.testapplication.ui.listItems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import kotlinx.android.synthetic.main.activity_fact_detail.*

class FactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact_detail)

        val fact = intent.getSerializableExtra("fact") as CatData

        factText.text = fact.fact
    }
}