package com.example.app_04_03.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "peliculas")
data class Pelicula(
    @PrimaryKey(autoGenerate = false)
    val id: Long,

    val titulo: String,

    val anyo: Int,

    val director: String?,

    @ColumnInfo(name = "puntos")
    val puntuacion: Float,

    val imagen: String?,

    val sinopsis: String,

    val favorita: Boolean
): java.io.Serializable
