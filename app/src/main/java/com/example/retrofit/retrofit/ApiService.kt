package com.example.retrofit.retrofit

import com.example.retrofit.classes.UnSplashUsers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?client_id=1pmL0rF2x7Bu5Jguvjhb0XsZk9nCWCS45pGogYggT4o")
    fun getUnSplashData(
        @Query("query") query: String,
        @Query("per_page") per_pager: Int = 30,
    ): Call<UnSplashUsers>

}