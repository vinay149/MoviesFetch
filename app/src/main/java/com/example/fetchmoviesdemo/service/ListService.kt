package com.example.fetchmoviesdemo.service

import com.example.fetchmoviesdemo.model.Movie
import retrofit2.http.GET

interface ListService {

    @GET("/?apikey=414edb62&s=popular&page=1")
    suspend fun getMovies(): Movie
}