package es.jaimedecos.app_ut2_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.jaimedecos.app_ut2_04.modelo.AnimalAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAnimales: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonAniadir = findViewById<FloatingActionButton>(R.id.floatingActionButtonAniadir)
        recyclerViewAnimales = findViewById<RecyclerView>(R.id.recyclerViewAnimales)

        recyclerViewAnimales.adapter = AnimalAdapter()
        recyclerViewAnimales.layoutManager = LinearLayoutManager(this)
        recyclerViewAnimales.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        botonAniadir.setOnClickListener {
            dialogoNuevoAnimal()
        }
    }

    private fun dialogoNuevoAnimal()
    {
        val inputEditTextField = EditText(this)
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo Animal")
            .setMessage("Introduce el nombre del nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir"){_,_ ->
                val nuevoAnimal = inputEditTextField.text.toString()
                (recyclerViewAnimales.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }
}