package com.example.fetchmoviesdemo.service

import com.example.fetchmoviesdemo.model.Detailtem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailsService {

    @GET("/")
    suspend fun getDetailsPage(@Query("i") imdb:String?,@Query("apiKey") apiKey:String): Detailtem
}