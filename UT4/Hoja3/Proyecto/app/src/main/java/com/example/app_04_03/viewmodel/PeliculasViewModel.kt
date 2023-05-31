package com.example.app_04_03.viewmodel

import android.content.Context
import android.text.Spannable.Factory
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.app_04_03.model.Pelicula
import com.example.app_04_03.model.datos.PeliculasRepository
import com.example.app_04_03.model.datos.basedatos.PeliculaDatabase
import kotlinx.coroutines.launch

class PeliculasViewModel(context: Context): ViewModel()
{
    private val repositorio :PeliculasRepository
    val peliculas: LiveData<List<Pelicula>>
    val peliculasFavoritas: LiveData<List<Pelicula>>

    init {
        val peliculaDao = PeliculaDatabase.getDatabase(context).peliculaDao()
        repositorio = PeliculasRepository(peliculaDao)
        peliculas = repositorio.get()
        peliculasFavoritas = repositorio.getFavoritas()
    }

    fun insertarPelicula(pelicula: Pelicula){
        viewModelScope.launch {
            repositorio.insertar(pelicula)
        }
    }
    fun borrarPelicula(pelicula: Pelicula){
        viewModelScope.launch {
            repositorio.delete(pelicula)
        }
    }
    fun cambiarFavorita(peliculaId: Long){
        viewModelScope.launch {
            repositorio.cambiarFavorita(peliculaId)
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val contexto = (this[APPLICATION_KEY] as Context)
                PeliculasViewModel(
                    context = contexto
                )
            }
        }
    }
}