package com.binarial.moviesapp.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.binarial.moviesapp.data.dataBase.entities.PeliculasFavoritasEntity

@Dao
interface PeliculasFavoritasDao {
    @Query("SELECT*FROM peliculaFavorita")
    suspend fun getPeliculasFavoritas(): List<PeliculasFavoritasEntity>

    @Insert
    suspend fun insertPeliculasFavoritas(peliculasFavoritasEntity: PeliculasFavoritasEntity): Long

    @Update
    suspend fun updatePeliculasFavoritas(peliculasFavoritasEntity: PeliculasFavoritasEntity)
}