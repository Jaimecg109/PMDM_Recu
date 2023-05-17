package com.example.preexamen.model

import java.io.Serializable

data class Equipo(
    var pais : String,
    var descripcio : String,
    var imagen : Int
): Serializable
