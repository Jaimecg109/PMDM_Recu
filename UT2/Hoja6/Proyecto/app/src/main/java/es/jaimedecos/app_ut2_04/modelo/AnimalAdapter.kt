package es.jaimedecos.app_ut2_04.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.jaimedecos.app_ut2_04.DatosAnimales
import es.jaimedecos.app_ut2_04.R

class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{

    private val listaAnimales = DatosAnimales.getDatosAnimales()

    class AnimalViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewAnimal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal
    }

    override fun getItemCount() = listaAnimales.size

    fun addAnimal(animal: String)
    {
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }

}