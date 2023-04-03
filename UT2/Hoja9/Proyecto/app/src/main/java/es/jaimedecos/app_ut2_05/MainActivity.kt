package es.jaimedecos.app_ut2_05

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.jaimedecos.app_ut2_05.MODELO.AnimalAdapter
import es.jaimedecos.app_ut2_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAnimales: RecyclerView
    private lateinit var binding: ActivityMainBinding

    private val segundaActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if (it.resultCode == Activity.RESULT_OK){
                val voto = it.data?.getIntExtra("voto",0)?:0
                val nombre = it.data?.getStringExtra("animal")?:""
                (recyclerViewAnimales.adapter as AnimalAdapter).cambiarVoto(nombre, voto)
                recyclerViewAnimales.adapter?.notifyDataSetChanged()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaAnimales = DatosAnimales.getDatosAnimales()
        val botonAniadir = findViewById<FloatingActionButton>(R.id.floatingActionButtonAniadir)
        recyclerViewAnimales = findViewById<RecyclerView>(R.id.recyclerViewAnimales)

        recyclerViewAnimales.adapter = AnimalAdapter(){animal -> onClickAnimal(animal) }
        recyclerViewAnimales.layoutManager = LinearLayoutManager(this)
        recyclerViewAnimales.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        botonAniadir.setOnClickListener {
            dialogoNuevoAnimal()
        }



    }

    private fun onClickAnimal(animal: Animal)
    {
        //Toast.makeText(this, "has pulsado un animal",Toast.LENGTH_LONG).show()
        val intent = Intent(applicationContext, DetalleAnimalActivity::class.java)
        intent.putExtra("animal", animal)
        startActivity(intent)
    }

    private fun dialogoNuevoAnimal()
    {
        val inputEditTextField = EditText(this)
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo Animal")
            .setMessage("Introduce el nombre del nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir"){_,_ ->
                val nuevoAnimal= Animal( inputEditTextField.text.toString(),R.drawable.desconocido,"",0)
                (recyclerViewAnimales.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }
}