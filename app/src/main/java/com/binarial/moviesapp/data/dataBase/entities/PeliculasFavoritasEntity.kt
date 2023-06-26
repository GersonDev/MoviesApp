package com.binarial.moviesapp.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "peliculaFavorita")
data class PeliculasFavoritasEntity(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "portada") val portada: String,
    @ColumnInfo(name = "titulo") val titulo: String,
    @ColumnInfo(name = "fecha") val fecha: String
)