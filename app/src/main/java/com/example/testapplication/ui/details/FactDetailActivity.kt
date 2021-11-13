package com.example.testapplication.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.utils.Params
import kotlinx.android.synthetic.main.activity_fact_detail.*

class FactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact_detail)

        val fact = intent.getSerializableExtra(Params.FACT) as? CatData
        fact?.let {
            factText.text = fact.fact
        }
    }
}