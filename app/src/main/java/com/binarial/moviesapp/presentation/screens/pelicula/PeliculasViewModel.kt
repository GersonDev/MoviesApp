package com.binarial.moviesapp.presentation.screens.pelicula

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binarial.moviesapp.domain.models.Pelicula
import com.binarial.moviesapp.domain.repositories.PeliculasRepository
import kotlinx.coroutines.launch

class PeliculasViewModel : ViewModel() {
    private val peliculasRepository = PeliculasRepository()

    val peliculasLiveData = MutableLiveData<List<Pelicula>>()

    fun getPeliculas() {
        viewModelScope.launch {
            val listaDePeliculas = peliculasRepository.getPeliculas()
            peliculasLiveData.value = listaDePeliculas
        }
    }
}