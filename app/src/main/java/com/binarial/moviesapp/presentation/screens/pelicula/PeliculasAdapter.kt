package com.binarial.moviesapp.presentation.screens.pelicula

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binarial.moviesapp.databinding.ItemPeliculaBinding
import com.binarial.moviesapp.domain.models.Pelicula
import com.bumptech.glide.Glide
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PeliculasAdapter(var peliculas: List<Pelicula> = mutableListOf()) :
    RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>() {

    var peliculaAdapterListener: PeliculaAdapterListener? = null

    private var listaOriginalDePeliculas = listOf<Pelicula>()

    inner class PeliculasViewHolder(val itemBinding: ItemPeliculaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(pelicula: Pelicula) {
            Glide.with(itemBinding.ivImagenPelicula.context)
                .load("https://image.tmdb.org/t/p/w500/${pelicula.poster_path}")
                .centerCrop()
                .into(itemBinding.ivImagenPelicula)
            itemBinding.tvTituloPelicula.text = pelicula.title
            itemBinding.rbCalificacion.rating = pelicula.vote_average.toFloat()

            val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val date = LocalDate.parse(pelicula.release_date, firstApiFormat)
            itemBinding.tvFechaDia.text = "${
                date.dayOfWeek.toString().toLowerCase().capitalize()
            } ${date.dayOfMonth} de ${
                date.month.toString().toLowerCase().capitalize()
            } del ${date.year}"

            itemBinding.root.setOnClickListener {
                peliculaAdapterListener?.onItemClick(pelicula)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val binding: ItemPeliculaBinding =
            ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeliculasViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        holder.bind(peliculas[position])
    }

    fun setListaFirstTIME(peliculasEncontradas: List<Pelicula>) {
        peliculas = peliculasEncontradas
        listaOriginalDePeliculas = peliculasEncontradas
        notifyDataSetChanged()
    }

    private fun setListaFiltrado(peliculasEncontradas: List<Pelicula>) {
        peliculas = peliculasEncontradas
        notifyDataSetChanged()
    }

    fun filtrarPeliculas(texto: String) {
        val peliculasEncontradas = mutableListOf<Pelicula>()
        if (texto.isEmpty()) {
            setListaFiltrado(listaOriginalDePeliculas)
        } else {

            for (pelicula in listaOriginalDePeliculas) {
                if (pelicula.title.toLowerCase().contains(texto.toLowerCase())) {
                    peliculasEncontradas.add(pelicula)
                }
            }
            setListaFiltrado(peliculasEncontradas)
        }
    }
}