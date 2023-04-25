package es.ivanlorenzo.app_ut3_01.model

import java.io.Serializable

data class Animal(val nombre:String, val imagenId: Int,
                  val descripcion: String = "", var votos: Int = 0) : Serializable
