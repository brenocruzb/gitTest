package com.example.testapplication.ui.facts.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.ui.facts.common.RecyclerAdapter
import com.example.testapplication.ui.facts.details.FactDetailActivity
import com.example.testapplication.ui.facts.favorites.FavoritesActivity
import com.example.testapplication.utils.Params
import com.example.testapplication.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()
    private val list = mutableListOf<CatData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        loadScreen(true)
        showError(false)

        lifecycleScope.launch {
            mainViewModel.loadCats().collect { results ->
                when(results.status) {
                    Status.SUCCESS -> {
                        Log.i("STATUS", "SUCCESS")
                        results.data?.let {
                            list.clear()
                            list.addAll(it.data)
                            recycler.adapter = RecyclerAdapter(list, ::onItemClick)
                        }
                    }
                    Status.ERROR -> {
                        Log.i("STATUS", "ERROR")
                        showError(true)
                        loadScreen(false)
                        errorText.text = results.exception?.message ?: ""
                    }
                    Status.LOADING -> {
                        Log.i("STATUS", "LOADING")
                        loadScreen(true)
                    }
                    Status.DONE -> {
                        Log.i("STATUS", "DONE")
                        loadScreen(false)
                    }
                }
            }
        }
    }

    private fun loadScreen(loading: Boolean) {
        progressBar.isVisible = loading
    }

    private fun showError(visibility: Boolean) {
        errorText.isVisible = visibility
    }

    private fun onItemClick(position: Int) {
        val intent = Intent(this, FactDetailActivity::class.java)
        intent.putExtra(Params.FACT, list[position])
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.favorites -> {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}