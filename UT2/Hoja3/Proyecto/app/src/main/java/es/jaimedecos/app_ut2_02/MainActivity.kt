package es.jaimedecos.app_ut2_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonContar = findViewById<Button>(R.id.btnContar)

        val botonToast = findViewById<Button>(R.id.btnMostrarToast)

        val texto = findViewById<TextView>(R.id.txtResultado)

        botonToast.setOnClickListener { contar() }

        botonContar.setOnClickListener{ contar(texto) }

    }

    private fun contar(texto: TextView) {

        contador++
        texto.text = contador.toString()

    }

    private fun contar(){

        Toast.makeText(this,"Se ha pulsado el boton $contador veces", Toast.LENGTH_SHORT).show()


    }
}