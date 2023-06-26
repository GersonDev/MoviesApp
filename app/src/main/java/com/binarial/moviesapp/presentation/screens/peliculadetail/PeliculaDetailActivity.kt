package com.binarial.moviesapp.presentation.screens.peliculadetail

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.binarial.moviesapp.R
import com.binarial.moviesapp.databinding.ActivityPeliculaDetailBinding
import com.binarial.moviesapp.domain.models.PeliculaDetail
import com.bumptech.glide.Glide

class PeliculaDetailActivity : AppCompatActivity() {

    val peliculaDetailViewModel = PeliculaDetailViewModel()
    var peliculaDetail: PeliculaDetail? = null

    private lateinit var binding: ActivityPeliculaDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeliculaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peliculaId = intent.getIntExtra("ID_KEY", 0)


        peliculaDetailViewModel.detailPeliculaLivedata.observe(this) {
            peliculaDetail = it

            Glide.with(binding.ivPortadaPelicula.context)
                .load("https://image.tmdb.org/t/p/w500/${it.imgenDePortada}")
                .centerCrop()
                .into(binding.ivPortadaPelicula)

            binding.tvTitlePeliculaDetail.text = it.titulo
            binding.tvFechaPeliculaDetail.text = it.releaseDate
            binding.rbCalificacionPeliculaDetail.rating = it.calificacion.toFloat()
            val listaDeNombres = it.generos.map {
                it.name
            }
            binding.tvGenerosPeliculaDetail.text = listaDeNombres.joinToString(" * ")
            binding.tvDescripcionPeliculaDetail.text = it.descripcion

        }
        peliculaDetailViewModel.getPeliculaDetail(peliculaId = peliculaId)
        binding.ivCorazon.setOnClickListener {
            peliculaDetailViewModel.guardarFavorito(this, peliculaDetail!!)
            binding.ivCorazon.setImageResource(R.drawable.icon_rojo)
        }
    }


}