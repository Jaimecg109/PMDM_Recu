package com.example.app_04_03.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import coil.load
import com.example.app_04_03.R
import com.example.app_04_03.databinding.FragmentDetalleBinding
import com.example.app_04_03.databinding.FragmentNuevaPeliculaBinding
import com.example.app_04_03.model.Pelicula
import com.example.app_04_03.viewmodel.PeliculasViewModel

class FragmentNuevaPelicula : Fragment() {


    private val peliculasViewModel: PeliculasViewModel by activityViewModels{ PeliculasViewModel.Factory}

    private lateinit var binding: FragmentNuevaPeliculaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNuevaPeliculaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextImagen.setOnFocusChangeListener { _, foco ->
            if(!foco &&
                    binding.editTextImagen.text.toString().isNotEmpty())
            {
                val userAgent = "Mozilla/5.0 (X11; Linux x86_64)" +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0" +
                        "Safari/537.36"
                val url = binding.editTextImagen.text.toString()
                binding.imageViewPelicula.load(url)
                {
                    addHeader("User-Agent", userAgent)
                }
            }
        }
        binding.btnInsertar.setOnClickListener {
            val titulo = binding.editTextTitulo.text.toString()
            val anyo = Integer.parseInt(binding.editTextAnno.text.toString())
            val director = binding.editTextDirector.text.toString()
            val puntuacion = binding.editTextAnno.text.toString().toFloat()
            val imagen = binding.editTextImagen.text.toString()
            val sinopsis = binding.editTextSinopsis.text.toString()
            peliculasViewModel.insertarPelicula(
                Pelicula(0, titulo, anyo, director, puntuacion, imagen, sinopsis, false)
            )
            view.findNavController().navigate(R.id.fragmenteListaPeliculas)
        }
    }

}