package com.ersinberkealemdaroglu.rickandmortyapp.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickApi {

    private const val BASE_URL = "https://forapp.dev/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: RickApiService by lazy{
        retrofit.create(RickApiService::class.java)
    }
}