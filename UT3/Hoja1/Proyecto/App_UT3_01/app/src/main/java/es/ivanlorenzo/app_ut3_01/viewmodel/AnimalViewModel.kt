package es.ivanlorenzo.app_ut3_01.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.ivanlorenzo.app_ut3_01.model.Animal
import es.ivanlorenzo.app_ut3_01.model.AnimalRepository

class AnimalViewModel: ViewModel()
{
    val animalesLiveData = MutableLiveData<List<Animal>>()
    val estaCargandoLiveData = MutableLiveData<Boolean>()

    private val repository = AnimalRepository()

    fun cargarDatos()
    {
        estaCargandoLiveData.postValue(true)
        animalesLiveData.postValue(repository.get())
        estaCargandoLiveData.postValue(false)
    }

    fun cambiarVoto(nombre: String, voto: Int)
    {
        val animal = animalesLiveData.value!!.first { a -> a.nombre == nombre }
        animal.votos+=voto
        animalesLiveData.value = animalesLiveData.value
    }
}