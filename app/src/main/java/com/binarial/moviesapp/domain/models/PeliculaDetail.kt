package com.binarial.moviesapp.domain.models

import com.binarial.moviesapp.data.api.response.Genero

data class PeliculaDetail(
    val id:Int,
    val imgenDePortada: String,
    val titulo: String,
    val releaseDate: String,
    val calificacion: Double,
    val generos: List<Genero>,
    val descripcion: String
)