package com.binarial.moviesapp.data.api.response

import com.binarial.moviesapp.domain.models.Pelicula

data class GetPeliculasReponse(
    val page: Int,
    val results: List<Pelicula>,
    val total_pages:Int,
    val total_results:Int
)


