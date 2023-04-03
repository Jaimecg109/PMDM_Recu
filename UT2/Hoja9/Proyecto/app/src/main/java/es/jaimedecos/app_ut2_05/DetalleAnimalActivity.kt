package es.jaimedecos.app_ut2_05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import es.jaimedecos.app_ut2_05.databinding.ActivityDetalleAnimalBinding

class DetalleAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animal = intent.extras?.get("animal") as Animal
        val imagen = findViewById<ImageView>(R.id.imageViewAnimal)
        val nombre = findViewById<TextView>(R.id.textViewNombre)
        val descripcion = findViewById<TextView>(R.id.textViewDescripcion)

        imagen.setImageResource(animal.imagenId)
        nombre.text = animal.nombre
        descripcion.text = animal.descripcion

        binding.buttonVotoPositivo.setOnClickListener {
            crearIntentAMain(animal,1)
        }
        binding.buttonVotoNegativo.setOnClickListener {
            crearIntentAMain(animal,-1)
        }

    }

    fun crearIntentAMain(animal: Animal,voto: Int)
    {
        val intentDevuelto = Intent()
        intentDevuelto.putExtra("voto", voto)
        intentDevuelto.putExtra("animal", animal.nombre)
        setResult(RESULT_OK,intentDevuelto)
        finish()
    }
}