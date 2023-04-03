package es.jaimedecos.app_ut2_05

import java.io.Serializable

data class Animal(
    val nombre : String,
    val imagenId : Int,
    val descripcion : String,
    var votos : Int
): Serializable
