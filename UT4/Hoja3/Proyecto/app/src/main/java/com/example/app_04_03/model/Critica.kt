package com.example.app_04_03.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "criticas",
    foreignKeys =
        [ForeignKey(
            entity = Pelicula::class,
            childColumns = ["pelicula_id"],
            parentColumns = ["id"],
            onDelete = CASCADE
        )]
    )
data class Critica(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val texto:String,
    val valoracion: String,

    @ColumnInfo(name = "pelicula_id")
    val peliculaId:Long
): java.io.Serializable
