package com.example.fetchmoviesdemo.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitService = Retrofit.Builder().baseUrl("https://www.omdbapi.com/").addConverterFactory(GsonConverterFactory.create()).build();

object SerachApi {
    val service : ListService by lazy {
        retrofitService.create(ListService::class.java)
    }
    val detailsService:DetailsService by lazy {
        retrofitService.create(DetailsService::class.java)
    }
}
