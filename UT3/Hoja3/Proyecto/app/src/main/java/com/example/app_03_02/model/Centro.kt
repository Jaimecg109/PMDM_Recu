package com.example.app_03_02.model

import com.google.gson.annotations.SerializedName

data class Centro(
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("direccion")
    val direccion: String,
    @SerializedName("horario")
    val horario: String,
    @SerializedName("localizacion")
    val localizacion: String,
    @SerializedName("telefono")
    val telefono: String,
    @SerializedName("web")
    val web: String
): java.io.Serializable
