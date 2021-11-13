package com.example.testapplication.di

import com.example.testapplication.data.local.LocalFactManager
import com.example.testapplication.data.rest.CatApi
import com.example.testapplication.data.rest.CatRepository
import com.example.testapplication.ui.facts.details.FactDetailViewModel
import com.example.testapplication.ui.facts.favorites.FavoritesViewModel
import com.example.testapplication.ui.facts.list.MainViewModel
import com.example.testapplication.ui.listItems.MainViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { catApi(get()) }
    single { provideRetrofit(get()) }
}

val localModule = module {
    single { LocalFactManager(get()) }
}

val catRepositoryModule = module {
    factory { CatRepository(get()) }
}

val mainViewModelModule = module {
    factory { MainViewModel(get()) }
}

val favoritesViewModelModule = module {
    factory { FavoritesViewModel(get()) }
}

val detailViewModelModule = module {
    factory { FactDetailViewModel(get()) }
}

private val json = Json {
    ignoreUnknownKeys = true
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = MediaType.get("application/json")
    return Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun catApi(retrofit: Retrofit): CatApi = retrofit.create(CatApi::class.java)
