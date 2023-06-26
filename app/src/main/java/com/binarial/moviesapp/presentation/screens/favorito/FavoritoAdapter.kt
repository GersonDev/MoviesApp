package com.binarial.moviesapp.presentation.screens.favorito

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binarial.moviesapp.databinding.ItemFavoritoBinding
import com.binarial.moviesapp.domain.models.Favorito
import com.binarial.moviesapp.domain.models.Pelicula
import com.bumptech.glide.Glide
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FavoritoAdapter(var favoritos: MutableList<Favorito> = mutableListOf()) :
    RecyclerView.Adapter<FavoritoAdapter.FavoritoViewHolder>() {

    inner class FavoritoViewHolder(val itemBinding: ItemFavoritoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(favorito: Favorito) {
            Glide.with(itemBinding.ivImagenFavorita.context)
                .load("https://image.tmdb.org/t/p/w500/${favorito.imagenFavorito}")
                .centerCrop()
                .into(itemBinding.ivImagenFavorita)
            itemBinding.tvNombrePelicula.text = favorito.nombrePeliculaFavorito

            val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val date = LocalDate.parse(favorito.fechaFavorito, firstApiFormat)
            itemBinding.tvFechaPelicula.text = " ${date.dayOfMonth}  ${
                date.month.toString().toLowerCase().capitalize()
            }  ${date.year}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritoViewHolder {
        val binding: ItemFavoritoBinding =
            ItemFavoritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return favoritos.size
    }

    override fun onBindViewHolder(holder: FavoritoViewHolder, position: Int) {
        holder.bind(favoritos[position])
    }

    fun agregarFavoritos(listDeFavoritos: List<Favorito>) {
        favoritos.addAll(listDeFavoritos)
        notifyDataSetChanged()
    }
}