package com.example.testapplication.di

import com.example.testapplication.data.rest.CatApi
import com.example.testapplication.data.rest.CatRepository
import com.example.testapplication.ui.listItems.MainViewModel
import com.google.gson.GsonBuilder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { catApi(get()) }
    single { provideRetrofit(get()) }
}

val catRepositoryModule = module {
    factory { CatRepository(get()) }
}

val mainViewModelModule = module {
    factory { MainViewModel(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = MediaType.get("application/json")
    val gson = GsonBuilder().setLenient().create()
    return Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .addConverterFactory(Json.asConverterFactory(contentType))
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun catApi(retrofit: Retrofit): CatApi = retrofit.create(CatApi::class.java)
