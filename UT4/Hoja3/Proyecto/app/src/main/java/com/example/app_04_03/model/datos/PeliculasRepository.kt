package com.example.app_04_03.model.datos

import androidx.lifecycle.LiveData
import com.example.app_04_03.model.Pelicula
import com.example.app_04_03.model.datos.basedatos.PeliculaDao

class PeliculasRepository(private val peliculaDao: PeliculaDao)
{

    fun get(): LiveData<List<Pelicula>> = peliculaDao.getPeliculas()
    fun getFavoritas(): LiveData<List<Pelicula>> = peliculaDao.getFavoritas()

    suspend fun insertar(pelicula: Pelicula){
        peliculaDao.insert(pelicula)
    }
    suspend fun delete(pelicula: Pelicula){
        peliculaDao.deleteById(pelicula.id)
    }
    suspend fun cambiarFavorita(peliculaId: Long){
        peliculaDao.cambiarFavorita(peliculaId)
    }
}