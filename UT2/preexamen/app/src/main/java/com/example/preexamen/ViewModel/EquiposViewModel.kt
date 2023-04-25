package com.example.preexamen.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.preexamen.model.Equipo
import com.example.preexamen.model.datos.DatosSelecciones

class EquiposViewModel : ViewModel() {

    private val _listaEquipos = MutableLiveData<List<Equipo>>()

    val listaEquipos = _listaEquipos

    fun cargarEquipos()
    {
        _listaEquipos.postValue(DatosSelecciones.equipos())
    }

}