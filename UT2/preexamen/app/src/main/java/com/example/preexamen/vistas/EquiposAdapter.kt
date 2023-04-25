package com.example.preexamen.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.preexamen.R
import com.example.preexamen.ViewModel.EquiposViewModel

class EquiposAdapter(val viewModel: EquiposViewModel)
    : RecyclerView.Adapter<EquiposAdapter.EquipoViewHolder>()
{

    val equipos = viewModel.listaEquipos.value ?: listOf()

        class EquipoViewHolder(view: View)
            :RecyclerView.ViewHolder(view)
        {
                val nombre = view.findViewById<TextView>(R.id.textViewNombre)
                val bandera = view.findViewById<ImageView>(R.id.imagenBandera)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipo, parent, false)

        return EquipoViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = equipos.size

    override fun onBindViewHolder(holder: EquipoViewHolder, position: Int) {
        val equipo = equipos[position]
        holder.nombre.text = equipo.pais
        holder.bandera.setImageResource(equipo.imagen)
    }

}