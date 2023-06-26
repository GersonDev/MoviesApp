package com.binarial.moviesapp.presentation.screens.principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.binarial.moviesapp.R
import com.binarial.moviesapp.databinding.ActivityPantallaPrincipalBinding
import com.binarial.moviesapp.presentation.screens.favorito.FavoritoFragment
import com.binarial.moviesapp.presentation.screens.pelicula.PeliculasFragment

class PantallaPrincipalActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityPantallaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(PeliculasFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.favoritos->replaceFragment(FavoritoFragment())
                R.id.peliculas->replaceFragment(PeliculasFragment())
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Layout, fragment)
        fragmentTransaction.commit()
    }
}