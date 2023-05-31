package com.example.app_04_03.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.app_04_03.R
import com.example.app_04_03.databinding.PeliculaItemBinding
import com.example.app_04_03.model.Pelicula

class PeliculasAdapter(private val listaPeliculas: List<Pelicula>,
                       private val onClickPelicula: (Pelicula) -> Unit,
                       private val cambiarFavorita: (Pelicula) -> Unit)
    :RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>()
{
    class PeliculasViewHolder(view: View)
        : RecyclerView.ViewHolder(view)
    {
            private val binding = PeliculaItemBinding.bind(view)

            fun bind(pelicula: Pelicula,
                     onClickPelicula: (Pelicula) -> Unit,
                     cambiarFavorita: (Pelicula) -> Unit   )
            {
                val userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                        "Chrome/108.0.0.0 Safari/537.36"
                val url = pelicula.imagen

                binding.apply {
                    imageViewPelicula.load(url){
                        addHeader("User-agent", userAgent)
                    }
                    textViewTitulo.text = pelicula.titulo
                    textViewAnno.text = pelicula.anyo.toString()
                    textViewDirector.text = pelicula.director
                    textViewNota.text = pelicula.puntuacion.toString()
                    imageButtonFavorito.setOnClickListener { cambiarFavorita(pelicula) }
                    if (pelicula.favorita)
                    {
                        imageButtonFavorito.setImageResource(R.drawable.favorito)
                    }else{
                        imageButtonFavorito.setImageResource(R.drawable.no_favorito)
                    }
                    ItemLayout.setOnClickListener { onClickPelicula(pelicula) }
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
       val adapterLayout = LayoutInflater.from(parent.context)
           .inflate(R.layout.pelicula_item, parent, false)

        return PeliculasViewHolder(adapterLayout)
    }


    override fun getItemCount(): Int = listaPeliculas.size

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = listaPeliculas[position]
        holder.bind(pelicula, onClickPelicula, cambiarFavorita)
    }

}