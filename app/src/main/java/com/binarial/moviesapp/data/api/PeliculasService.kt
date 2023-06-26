package com.binarial.moviesapp.data.api

import com.binarial.moviesapp.data.api.response.GetDetailPeliculasResponse
import com.binarial.moviesapp.data.api.response.GetPeliculasReponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PeliculasService {
    @GET("movie/popular")
    suspend fun getPeliculas(@Query("api_key") apiKey: String): GetPeliculasReponse

    @GET("movie/{movieId}")
    suspend fun getDetailPelicula(@Path("movieId") movieId: Int,@Query("api_key") apiKey: String):GetDetailPeliculasResponse

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}