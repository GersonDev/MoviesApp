package com.binarial.moviesapp.data.api.response

data class GetDetailPeliculasResponse(
    val id:Int,
    val poster_path: String,
    val original_title: String,
    val release_date: String,
    val vote_average: Double,
    val genres: List<Genero>,
    val overview: String
)

data class Genero(
    val id: Int,
    val name: String
)


