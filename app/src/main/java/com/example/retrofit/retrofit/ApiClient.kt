package com.example.retrofit.retrofit

import android.content.Context
import com.mocklets.pluto.PlutoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL =
        "https://api.unsplash.com/search/photos/"

    fun getRetrofit(context: Context): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PlutoInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun apiService(context: Context) = getRetrofit(context).create(ApiService::class.java)
}