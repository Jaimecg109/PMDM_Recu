package com.example.app_04_03.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.app_04_03.R
import com.example.app_04_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

   private val fragmentListaPeliculas = FragmenteListaPeliculas()
   private val fragmentListaFavoritas = FragmentListaFavoritas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open,
            R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setCheckedItem(R.id.menu_lista)
            navView.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.menu_lista -> {
                    }
                    R.id.menu_add -> {
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }
          opcionesMenu()
        }

    }
    private fun opcionesMenu() {
        binding.viewBottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.peliculas -> setFragment(fragmentListaPeliculas)
                R.id.favoritas -> setFragment(fragmentListaFavoritas)
            }
            true
        }
    }
    private fun setFragment(fragmenttoChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmenttoChange)
            .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return  super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}