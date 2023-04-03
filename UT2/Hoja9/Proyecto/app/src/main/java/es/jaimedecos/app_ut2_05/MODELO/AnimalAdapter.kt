package es.jaimedecos.app_ut2_05.MODELO

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.jaimedecos.app_ut2_05.Animal
import es.jaimedecos.app_ut2_05.DatosAnimales
import es.jaimedecos.app_ut2_05.R

class AnimalAdapter(
                    private val onClickAnimal: (Animal) -> Unit)
    : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{

    private val listaAnimales = DatosAnimales.getDatosAnimales()

    class AnimalViewHolder(view: View,
                            private val onClickAnimal: (Animal) -> Unit)
        : RecyclerView.ViewHolder(view)
    {

        init {
            view.setOnClickListener { onClickAnimal }
        }
        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewAnimal)
        val imageViewAnimal = view.findViewById<ImageView>(R.id.imageViewAnimal)
        val votos = view.findViewById<TextView>(R.id.textViewVotos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout, onClickAnimal)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal.nombre
        holder.imageViewAnimal.setImageResource(animal.imagenId)
        holder.votos.text = animal.votos.toString() + " votos"
        holder.itemView.setOnClickListener { onClickAnimal(animal) }
    }

    override fun getItemCount() = listaAnimales.size

    fun addAnimal(animal: Animal)
    {
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }
    fun cambiarVoto(nombre: String,voto:Int){

        listaAnimales.forEach { if (it.nombre.equals(nombre)){
            it.votos += voto


        }
        }

    }

}