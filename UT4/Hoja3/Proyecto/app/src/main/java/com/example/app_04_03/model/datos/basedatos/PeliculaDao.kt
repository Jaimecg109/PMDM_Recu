package com.example.app_04_03.model.datos.basedatos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.app_04_03.model.Pelicula

@Dao
interface PeliculaDao
{
    @Query("SELECT * FROM peliculas WHERE favorita = 0 ORDER BY puntos ASC")
    fun getPeliculas(): LiveData<List<Pelicula>>

    @Query("SELECT * FROM peliculas WHERE favorita = 1")
    fun getFavoritas(): LiveData<List<Pelicula>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pelicula: Pelicula)

    @Query("DELETE FROM peliculas WHERE id = :peliculaId")
    suspend fun deleteById(peliculaId: Long)

    @Query("UPDATE peliculas SET favorita=1 WHERE id = :peliculaId")
    suspend fun cambiarFavorita(peliculaId: Long)
}