package com.example.testapplication.ui.listItems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.testapplication.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadScreen(true)

        val catsSubscriber = mainViewModel.loadCats(5).subscribe(
            { list ->
                val message = "Message = ${list[0].text}, Size = ${list.size}"
               text1.text = message
            }, //onNext
            { exception ->
                text1.text = exception.message
                loadScreen(false)
            }, //onError
            {
                loadScreen(false)
            } //onComplete
        )

        compositeDisposable.add(catsSubscriber)
    }

    private fun loadScreen(loading: Boolean){
        text1.isVisible = !loading
        text2.isVisible = !loading
        progressBar.isVisible = loading
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}