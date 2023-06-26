package com.binarial.moviesapp.presentation.screens.favorito

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binarial.moviesapp.domain.models.Favorito
import com.binarial.moviesapp.domain.repositories.PeliculasDetailRepository
import kotlinx.coroutines.launch

class FavoritoViewModel : ViewModel() {

    private val peliculasDetailRepository = PeliculasDetailRepository()

    val peliculaFavoritasLiveData = MutableLiveData<List<Favorito>>()

    fun obtenerFavoritos(context: Context) {
        viewModelScope.launch {
            val listaDeFavoritos = peliculasDetailRepository.obtenerFavoritos(context = context)
            peliculaFavoritasLiveData.value = listaDeFavoritos
        }
    }
}