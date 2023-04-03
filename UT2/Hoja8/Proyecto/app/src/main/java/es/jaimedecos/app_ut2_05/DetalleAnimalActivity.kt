package es.jaimedecos.app_ut2_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalleAnimalActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_animal)
        val animal = intent.extras?.get("animal") as Animal
        val imagen = findViewById<ImageView>(R.id.imageViewAnimal)
        val nombre = findViewById<TextView>(R.id.textViewNombre)
        val descripcion = findViewById<TextView>(R.id.textViewDescripcion)

        imagen.setImageResource(animal.imagenId)
        nombre.text = animal.nombre
        descripcion.text = animal.descripcion

    }
}