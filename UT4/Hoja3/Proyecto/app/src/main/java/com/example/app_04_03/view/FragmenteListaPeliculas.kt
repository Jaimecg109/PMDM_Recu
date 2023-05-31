package com.example.app_04_03.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_04_03.R
import com.example.app_04_03.databinding.FragmentFragmenteListaPeliculasBinding
import com.example.app_04_03.model.Pelicula
import com.example.app_04_03.viewmodel.PeliculasViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FragmenteListaPeliculas : Fragment() {
    private val peliculasViewModel: PeliculasViewModel by activityViewModels { PeliculasViewModel.Factory }
    private lateinit var binding: FragmentFragmenteListaPeliculasBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragmenteListaPeliculasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        peliculasViewModel.peliculas.observe(viewLifecycleOwner) { peliculas ->
            with(binding.recyclerview) {
                adapter = PeliculasAdapter(peliculas, { pelicula ->
                    onClickPelicula(pelicula)
                },{ pelicula ->
                    cambiarFavorito(pelicula)} )
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
    }


    private fun onClickPelicula(pelicula: Pelicula) {
        val accion =
            FragmenteListaPeliculasDirections.actionFragmenteListaPeliculasToFragmentDetalle(
                pelicula
            )
        view?.findNavController()?.navigate(accion)
    }


    private fun cambiarFavorito(pelicula: Pelicula) {
peliculasViewModel.cambiarFavorita(pelicula.id)
    }
}
