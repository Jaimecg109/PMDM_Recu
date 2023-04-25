package es.ivanlorenzo.app_ut3_01.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.ivanlorenzo.app_ut3_01.R
import es.ivanlorenzo.app_ut3_01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    private val fragmentAnimales = FragmentListaAnimales()
    private val fragmentFavoritos = FragmentFavoritos()



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(fragmentAnimales)
        opcionesMenu()
    }


    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }

    private fun opcionesMenu() {
            binding.viewBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.animales -> setFragment(fragmentAnimales)
                R.id.favoritos -> setFragment(fragmentFavoritos)
            }
            true
        }
    }




}