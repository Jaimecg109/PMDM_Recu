package com.example.app_04_01.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.example.app_04_01.R
import com.example.app_04_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencias = PreferenceManager.getDefaultSharedPreferences(this)

        binding.buttonBorrar.setOnClickListener {
            preferencias.edit().clear().commit()
        }
        binding.buttonCargar.setOnClickListener {
            binding.nombre.text = preferencias.getString("Nombre", null)
            binding.Email.text = preferencias.getString("Email", null)
            if(preferencias.getBoolean("MayorEdad", false))
                binding.MayorEdad.text = "Mayor de edad"
                else
                binding.MayorEdad.text = "Menor de edad"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu_preferencias, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(item.itemId == R.id.preferencias)
       {
           val intent = Intent(this@MainActivity,PreferenciasActivity::class.java)
           startActivity(intent)
           return true
       }
        return super.onOptionsItemSelected(item)
    }
}