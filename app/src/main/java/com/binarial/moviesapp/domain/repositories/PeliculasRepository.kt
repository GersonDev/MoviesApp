package com.binarial.moviesapp.domain.repositories

import com.binarial.moviesapp.data.api.PeliculasServiceImpl
import com.binarial.moviesapp.domain.models.Pelicula

class PeliculasRepository {
    val peliculasServiceImpl = PeliculasServiceImpl()
    val peliculasService = peliculasServiceImpl.peliculasService()

    suspend fun getPeliculas(): List<Pelicula> {
        val getPeliculasResponse = peliculasService.getPeliculas(apiKey = "d07046f8117f883981f167bdd7d8e97a")
        val listaDePeliculas = getPeliculasResponse.results
        return listaDePeliculas
    }
}