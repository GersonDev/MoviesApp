package com.binarial.moviesapp.presentation.screens.favorito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.binarial.moviesapp.databinding.FragmentFavoritoBinding

class FavoritoFragment : Fragment() {

    private var favoritoAdapter = FavoritoAdapter()
    private lateinit var binding: FragmentFavoritoBinding
    private val favoritoViewModel = FavoritoViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvGrillaFavoritos.adapter = favoritoAdapter
        favoritoViewModel.peliculaFavoritasLiveData.observe(viewLifecycleOwner) {
            favoritoAdapter.agregarFavoritos(it)
        }
        favoritoViewModel.obtenerFavoritos(requireContext())
    }
}