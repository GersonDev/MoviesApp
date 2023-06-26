package com.binarial.moviesapp.presentation.screens.peliculadetail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binarial.moviesapp.domain.models.PeliculaDetail
import com.binarial.moviesapp.domain.repositories.PeliculasDetailRepository
import kotlinx.coroutines.launch

class PeliculaDetailViewModel : ViewModel() {

    val peliculasDetailRepository = PeliculasDetailRepository()
    val detailPeliculaLivedata = MutableLiveData<PeliculaDetail>()


    fun getPeliculaDetail(peliculaId: Int) {
        viewModelScope.launch {
            val detailPelicula = peliculasDetailRepository.getDetailPelicula(peliculaId)
            detailPeliculaLivedata.value = detailPelicula
        }
    }

    fun guardarFavorito(context: Context, peliculaDetail: PeliculaDetail) {
        viewModelScope.launch {
            peliculasDetailRepository.guardarFavorito(context, peliculaDetail)
        }
    }
}