package com.example.app_ut2_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.app_ut2_07.modelo.ProductoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewProductos: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categorias = Datos.nombresCategorias()
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, categorias)

        val spinner = findViewById<Spinner>(R.id.spinnerCategoria)
        spinner.adapter = adapter

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducto)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val texto = p0?.selectedItem.toString()
                val productos = Datos.getProductosCategoria(texto)
                recyclerView.adapter = ProductoAdapter(productos){onClickProducto()}

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    private fun onClickProducto()
    {

    }
}