package es.jaimedecos.app_ut2_03

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var imagen: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgDestino = findViewById<ImageView>(R.id.imageViewDestino)
        val radioGroup = findViewById<RadioGroup>(R.id.opcionViaje)
        val switchIVA = findViewById<Switch>(R.id.switch_iva)
        val mostrar = findViewById<Button>(R.id.boton_mostrar)

        establecerPrecio(radioGroup.checkedRadioButtonId,switchIVA.isChecked)

        mostrar.setOnClickListener {
            if (imagen!=null)
            imgDestino.setImageResource(imagen!!)
        }

        radioGroup.setOnCheckedChangeListener { radioGroup, opcion ->
            establecerPrecio(opcion, switchIVA.isChecked)
        }

        switchIVA.setOnCheckedChangeListener { compoundButton, b ->
            establecerPrecio(radioGroup.checkedRadioButtonId,
                switchIVA.isChecked)
        }

    }

    private fun establecerPrecio(radioButtonId: Int, iva: Boolean)
    {
        val textViewPrecioFinal = findViewById<TextView>(R.id.precio_final)
        val precio = calcularPrecio(radioButtonId, iva)
        textViewPrecioFinal.text = "${String.format("%.2f", precio)} €"

        //Cambiar color en función del precio
        val presupuestoEditText = findViewById<EditText>(R.id.presupuesto)
        val presupuesto = presupuestoEditText.text.toString().toDoubleOrNull()

        if (presupuesto != null) {
            if(presupuesto>precio)
                textViewPrecioFinal.setTextColor(getColor(R.color.verde))
            else
                textViewPrecioFinal.setTextColor(getColor(R.color.rojo))
        }


    }

    private fun calcularPrecio(radioButtonId: Int, iva: Boolean): Double
    {
        var precio: Double = 0.0
        when(radioButtonId)
        {
            R.id.opcion_peninsula -> {
              precio=600.0
                imagen = R.drawable.costa_peninsular
            }
            R.id.opcion_islas -> {
               precio=900.0
                imagen = R.drawable.costa_insular
            }
            else -> {
                precio=520.0
                imagen = R.drawable.turismo_interior
            }
        }
        if(iva)
            precio *= 1.21

        return precio

        //return if(iva) precio*1.21 else precio
    }
}