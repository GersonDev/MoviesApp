package com.binarial.moviesapp.presentation.screens.pelicula

import com.binarial.moviesapp.domain.models.Pelicula

interface PeliculaAdapterListener {
    fun onItemClick(pelicula: Pelicula)
}