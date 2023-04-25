package es.ivanlorenzo.app_ut3_01.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import es.ivanlorenzo.app_ut3_01.databinding.ActivityDetalleAnimalBinding
import es.ivanlorenzo.app_ut3_01.model.Animal

class DetalleAnimalActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityDetalleAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val animal = intent.extras?.get("animal") as Animal
        binding.textViewNombre.text = animal.nombre
        binding.textViewDescripcion.text = animal.descripcion
        binding.textViewDescripcion.movementMethod = ScrollingMovementMethod()
        binding.imageViewAnimal.setImageResource(animal.imagenId)

        binding.imageViewFavorito.setOnClickListener {
            binding.imageViewFavorito.setColorFilter(Color.parseColor("#FFDAA95E"))
        }


        binding.botonPositivo.setOnClickListener {
            crearIntentAMain(animal, 1)
        }

        binding.botonNegativo.setOnClickListener {
            crearIntentAMain(animal, -1)
        }

    }


    private fun crearIntentAMain(animal: Animal, voto: Int)
    {
        val intentDevuelto = Intent()
        intentDevuelto.putExtra("voto", voto)
        intentDevuelto.putExtra("animal", animal.nombre)
        setResult(RESULT_OK, intentDevuelto)
        finish()
    }
}