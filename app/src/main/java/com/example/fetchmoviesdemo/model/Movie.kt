package com.example.fetchmoviesdemo.model

data class Movie(
    val Search:List<MovieItem>
)

data class MovieItem(
    val Title:String = "",
    val Year:String = "",
    val Type:String = "",
    val Poster:String = "",
    val imdbID:String = ""
)