package com.example.testapplication

import android.app.Application
import com.example.testapplication.di.*
import org.koin.core.context.startKoin

class StartApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(
                networkModule,
                localModule,
                catRepositoryModule,
                mainViewModelModule,
                favoritesViewModelModule
            ))
        }
    }
}