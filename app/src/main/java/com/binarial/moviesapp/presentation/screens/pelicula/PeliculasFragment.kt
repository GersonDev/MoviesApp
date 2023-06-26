package com.binarial.moviesapp.presentation.screens.pelicula

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.binarial.moviesapp.databinding.FragmentPeliculaBinding
import com.binarial.moviesapp.domain.models.Pelicula
import com.binarial.moviesapp.presentation.screens.peliculadetail.PeliculaDetailActivity

class PeliculasFragment : Fragment() {

    private lateinit var binding: FragmentPeliculaBinding
    private val peliculasViewModel = PeliculasViewModel()
    private val peliculasAdapter = PeliculasAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeliculaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.svBuscador.clearFocus()
        binding.svBuscador.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                peliculasAdapter.filtrarPeliculas(newText!!)
                if (peliculasAdapter.peliculas.isEmpty()) {
                    binding.tvNoResultados.visibility = View.VISIBLE
                }else{
                    binding.tvNoResultados.visibility = View.INVISIBLE
                }
                return true
            }
        })


        binding.rvPeliculas.adapter = peliculasAdapter
        peliculasAdapter.peliculaAdapterListener = object : PeliculaAdapterListener {
            override fun onItemClick(pelicula: Pelicula) {
                val intent = Intent(
                    this@PeliculasFragment.requireContext(),
                    PeliculaDetailActivity::class.java
                )
                intent.putExtra("ID_KEY", pelicula.id)
                startActivity(intent)
            }

        }

        peliculasViewModel.peliculasLiveData.observe(viewLifecycleOwner) {
            peliculasAdapter.setListaFirstTIME(it)
        }
        peliculasViewModel.getPeliculas()
    }

}


