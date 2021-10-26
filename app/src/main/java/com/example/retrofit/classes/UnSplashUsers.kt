package com.example.retrofit.classes

data class UnSplashUsers(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)