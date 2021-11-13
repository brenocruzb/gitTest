package com.example.testapplication

import android.app.Application
import com.example.testapplication.di.catRepositoryModule
import com.example.testapplication.di.localModule
import com.example.testapplication.di.mainViewModelModule
import com.example.testapplication.di.networkModule
import org.koin.core.context.startKoin

class StartApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(
                networkModule,
                localModule,
                catRepositoryModule,
                mainViewModelModule
            ))
        }
    }
}