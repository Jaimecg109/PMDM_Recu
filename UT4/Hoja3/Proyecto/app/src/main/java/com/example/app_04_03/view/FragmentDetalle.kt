package com.example.app_04_03.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.app_04_03.R
import com.example.app_04_03.databinding.FragmentDetalleBinding
import com.example.app_04_03.model.Pelicula
import com.example.app_04_03.viewmodel.PeliculasViewModel

class FragmentDetalle : Fragment() {

    private val peliculasViewModel: PeliculasViewModel by activityViewModels{PeliculasViewModel.Factory}

    private lateinit var binding: FragmentDetalleBinding
    private lateinit var pelicula: Pelicula
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (pelicula.favorita) {
            binding.imageViewFav.setImageResource(R.drawable.favorito)
        }
        binding.imageViewBorrar.setOnClickListener {
            val dialog = AlertDialog.Builder(this.context)
            dialog.setTitle("¿Borrar pelicula?")
            dialog.setMessage("¿Estas seguro que desea borrar la pelicula ${pelicula.titulo}?")
            dialog.setPositiveButton(R.string.si){_,_->
                peliculasViewModel.borrarPelicula(pelicula)
                view.findNavController().navigate(R.id.fragmenteListaPeliculas)
            }
           dialog.show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pelicula = it.get("pelicula") as Pelicula
        }
    }


}