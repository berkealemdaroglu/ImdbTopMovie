package com.ersinberkealemdaroglu.rickandmortyapp.service

import com.ersinberkealemdaroglu.rickandmortyapp.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface RickApiService {
    @GET("movie.json")
    fun getProperties(): Call<List<MovieModel>>
}