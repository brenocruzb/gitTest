package com.example.testapplication.ui.facts.favorites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.ui.facts.common.RecyclerAdapter
import com.example.testapplication.ui.facts.details.FactDetailActivity
import com.example.testapplication.utils.Params
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_favorites.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesActivity : AppCompatActivity() {
    private val viewModel by viewModel<FavoritesViewModel>()
    private val compositeDisposable = CompositeDisposable()
    private val list = mutableListOf<CatData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val subscriber = viewModel.loadLocalCats().subscribe { facts ->
            list.clear()
            list.addAll(facts.map { CatData(it, 0) })
            recycler.adapter = RecyclerAdapter(list, ::onItemClick)
        }

        compositeDisposable.add(subscriber)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun onItemClick(position: Int) {
        val intent = Intent(this, FactDetailActivity::class.java)
        intent.putExtra(Params.FACT, list[position])
        startActivity(intent)
    }
}