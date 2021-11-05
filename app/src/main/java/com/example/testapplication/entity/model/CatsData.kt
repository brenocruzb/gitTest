package com.example.testapplication.entity.model

data class CatsData(
    val currentPage : Int,
    val data : List<CatData>,
    val total : Int,
    val lastPage : Int,
)