package com.example.testapplication.ui.listItems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import com.example.testapplication.utils.Params
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {

    private val mainViewModel by viewModel<MainViewModel>()
    private val compositeDisposable = CompositeDisposable()
    private var list = listOf<CatData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadScreen(true)
        showError(false)

        val catsSubscriber = mainViewModel.loadCats().subscribe(
            { cats ->
                list = cats.data
                recycler.adapter = RecyclerAdapter(list, this)
            }, //onNext
            { exception ->
                showError(true)
                errorText.text = "${applicationContext.getString(R.string.error)} ${exception.message}"
                loadScreen(false)
            }, //onError
            {
                loadScreen(false)
            } //onComplete
        )

        compositeDisposable.add(catsSubscriber)
    }

    private fun loadScreen(loading: Boolean) {
        progressBar.isVisible = loading
    }

    private fun showError(visibility: Boolean) {
        errorText.isVisible = visibility
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, FactDetailActivity::class.java)
        intent.putExtra(Params.FACT, list[position])
        startActivity(intent)
    }
}