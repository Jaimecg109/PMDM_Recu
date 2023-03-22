package es.jaimedecos.app_ut2_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val datos = linkedMapOf<String,Int>("logo" to R.drawable.sin_t_tulo, "avatar1" to R.drawable.avatar1)
    private var contador = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.button)
        val imagen = findViewById<ImageView>(R.id.imageView)
        val texto = findViewById<TextView>(R.id.textView)

        boton.setOnClickListener {
            cambiarImagenYTexto(texto,imagen)
        }

    }

    private fun cambiarImagenYTexto(texto: TextView, imagen: ImageView) {
        contador++
        contador%=datos.size

        val text = datos.keys.elementAt(contador)
        texto.text = text
        imagen.setImageResource(datos[text]!!)

        Toast.makeText(this,"Has cambiado el valor a $text", Toast.LENGTH_SHORT).show()
    }


}