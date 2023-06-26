package com.binarial.moviesapp.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.binarial.moviesapp.data.dataBase.dao.PeliculasFavoritasDao
import com.binarial.moviesapp.data.dataBase.entities.PeliculasFavoritasEntity

@Database(entities = [PeliculasFavoritasEntity::class], version = 1, exportSchema = false)
abstract class PeliculasFavoritasDataBase : RoomDatabase() {

    abstract fun peliculasFavoritasDao(): PeliculasFavoritasDao

    companion object {
        fun buildDataBase(context: Context): PeliculasFavoritasDataBase {
            return Room.databaseBuilder(
                context,
                PeliculasFavoritasDataBase::class.java,
                "PeliculasFavoritasDataBase"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}