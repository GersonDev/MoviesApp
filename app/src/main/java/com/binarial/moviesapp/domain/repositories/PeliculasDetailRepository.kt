package com.binarial.moviesapp.domain.repositories

import android.content.Context
import com.binarial.moviesapp.data.api.PeliculasServiceImpl
import com.binarial.moviesapp.data.dataBase.PeliculasFavoritasDataBase
import com.binarial.moviesapp.data.dataBase.entities.PeliculasFavoritasEntity
import com.binarial.moviesapp.domain.models.Favorito
import com.binarial.moviesapp.domain.models.PeliculaDetail

class PeliculasDetailRepository {
    var peliculasServiceImpl = PeliculasServiceImpl()
    val peliculasService = peliculasServiceImpl.peliculasService()


    suspend fun getDetailPelicula(peliculaId: Int): PeliculaDetail {
        val getPeliculasDetailResponse = peliculasService.getDetailPelicula(
            movieId = peliculaId,
            apiKey = "d07046f8117f883981f167bdd7d8e97a"
        )
        val peliculaDetail = PeliculaDetail(
            id = getPeliculasDetailResponse.id,
            imgenDePortada = getPeliculasDetailResponse.poster_path,
            titulo = getPeliculasDetailResponse.original_title,
            calificacion = getPeliculasDetailResponse.vote_average,
            releaseDate = getPeliculasDetailResponse.release_date,
            generos = getPeliculasDetailResponse.genres,
            descripcion = getPeliculasDetailResponse.overview
        )
        return peliculaDetail
    }

    suspend fun guardarFavorito(context: Context, peliculaDetail: PeliculaDetail) {
        val peliculasFavoritasDao =
            PeliculasFavoritasDataBase.buildDataBase(context).peliculasFavoritasDao()
        val peliculasFavoritasEntity = PeliculasFavoritasEntity(
            id =peliculaDetail.id,
            portada = peliculaDetail.imgenDePortada,
            titulo = peliculaDetail.titulo,
            fecha = peliculaDetail.releaseDate,
        )
        peliculasFavoritasDao.insertPeliculasFavoritas(peliculasFavoritasEntity)
    }

    suspend fun obtenerFavoritos(context: Context): List<Favorito> {
        val peliculasFavoritasDao =
            PeliculasFavoritasDataBase.buildDataBase(context).peliculasFavoritasDao()
        val listaDePeliculasFavoritosEntity = peliculasFavoritasDao.getPeliculasFavoritas()
        val listaDeFavorito = listaDePeliculasFavoritosEntity.map {
            Favorito(
                imagenFavorito = it.portada,
                nombrePeliculaFavorito = it.titulo,
                fechaFavorito = it.fecha,
            )
        }
        return listaDeFavorito
    }
    //agregar funcion de obtenerlista de favoritos
    //terminar diseño del detalle
    //agregarviewmodels al fragmento favorito
    //terminar el adparter de favoritos
    //investigar 2 grillas de reclyclerview
    //agregar readme al proyecto
    // crear repo al github
}