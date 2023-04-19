package com.example.app_ut2_07.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_07.Producto
import com.example.app_ut2_07.R

class ProductoAdapter(
    private val listaProductos: List<Producto>,
    private val onClickProducto: (Producto) -> Unit

) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>()
{

    class ProductoViewHolder(view: View,
                             private val onClickProducto: (Producto) -> Unit)
        : RecyclerView.ViewHolder(view)
    {
            init {
                view.setOnClickListener { onClickProducto }
            }
        val textViewNombreProducto = view.findViewById<TextView>(R.id.textViewProducto)
        val imageViewAnimal = view.findViewById<ImageView>(R.id.imageViewProducto)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)

        return ProductoViewHolder(adapterLayout, onClickProducto)
    }

    override fun getItemCount() = listaProductos.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]
        holder.imageViewAnimal.setImageResource(producto.imagenId)
        holder.textViewNombreProducto.text = producto.nombre
    }

}