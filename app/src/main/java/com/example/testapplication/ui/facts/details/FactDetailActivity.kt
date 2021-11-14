package com.example.testapplication.ui.facts.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.utils.Params
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_fact_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FactDetailActivity : AppCompatActivity() {
    private val viewModel by viewModel<FactDetailViewModel>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact_detail)
        setSupportActionBar(toolbar)

        val fact = intent.getSerializableExtra(Params.FACT) as? CatData
        fact?.let {
            factText.text = fact.fact
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.favorites -> {
            val subscriber = viewModel.addFavorite(factText.text.toString()).subscribe(
                { success ->
                    Toast.makeText(this, success, Toast.LENGTH_LONG).show()
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                }
            )
            compositeDisposable.add(subscriber)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}