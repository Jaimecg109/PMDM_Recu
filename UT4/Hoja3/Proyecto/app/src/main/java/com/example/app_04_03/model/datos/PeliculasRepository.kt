package com.example.app_04_03.model.datos

import androidx.lifecycle.LiveData
import com.example.app_04_03.model.Pelicula
import com.example.app_04_03.model.datos.basedatos.PeliculaDao

class PeliculasRepository(private val peliculaDao: PeliculaDao)
{

    fun get(): LiveData<List<Pelicula>> = peliculaDao.getPeliculas()
}