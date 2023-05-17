package com.example.app_03_03.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.app_03_03.R
import com.example.app_03_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragmentLocalizacion = FragmentLocalizacion()
    private val fragmentMapa = FragmentMapa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(fragmentLocalizacion)
        opcionesMenu()
    }

    private fun opcionesMenu() {
        binding.viewBottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.localizacion -> setFragment(fragmentLocalizacion)
                R.id.mapa -> setFragment(fragmentMapa)
            }
            true
        }
    }

    private fun setFragment(fragmenttoChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmenttoChange)
            .commit()
    }
}