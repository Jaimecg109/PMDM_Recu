package es.jaimedecos.app_ut2_03

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var precioFinal : Double = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val ivaSwitch = findViewById<Switch>(R.id.switch_iva)
        val precio_final = findViewById<TextView>(R.id.precio_final)
        val presupuesto = findViewById<EditText>(R.id.Presupuesto)
        radioGroup.setOnCheckedChangeListener { p0, p1 ->

            var radio = findViewById<RadioButton>(p1)
            precioFinal = (radio.tag.toString()).toDouble()
            precio_final.text = precioFinal.toString()

        }



        ivaSwitch.setOnCheckedChangeListener { p0, p1 ->
            var precio: Double = precioFinal
            var precio_iva: Double = precio * 0.21
            var presupuestoNum = presupuesto.text.toString().toDouble()
           if(p1) {
                precio += precio_iva
                precio_final.text = precio.toString()
            }else{
               precio_final.text = precio.toString()
            }
            if (precio>presupuestoNum){
                precio_final.setTextColor(Color.parseColor("#FF0000"))
            }else{
                precio_final.setTextColor(Color.parseColor("#008000"))
            }
        }

    }

}