package com.example.app_04_03.model.datos.basedatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app_04_03.model.Critica
import com.example.app_04_03.model.Pelicula

@Database(
    entities = [Pelicula::class, Critica::class],
    version = 1
)
abstract class PeliculaDatabase : RoomDatabase()
{
    abstract fun peliculaDao(): PeliculaDao

    companion object{
        private var  INSTANCE: PeliculaDatabase? = null
        fun getDatabase(context: Context): PeliculaDatabase
        {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE=
                        Room.databaseBuilder(context,PeliculaDatabase::class.java,"peliculas.db")
                            .createFromAsset("peliculas-copiar.db")
                            .build()
                }
            }
            return  INSTANCE!!
        }
    }
}