package com.example.app_03_03.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

import com.example.app_03_03.R
import com.example.app_03_03.databinding.FragmentLocalizacionBinding
import com.google.android.gms.location.*
import java.util.*


class FragmentLocalizacion : Fragment() {

    private lateinit var  binding: FragmentLocalizacionBinding

    private lateinit var  fusedLocationClient: FusedLocationProviderClient

    private lateinit var  locationCallback: LocationCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLocalizacionBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            comprobarPermisos()
        }
    }

    private fun comprobarPermisos() {
        val permisos = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION)
        if(!tienePermisos(permisos))
            solicitarPermisos(permisos)
        else
            geolocalizar()
    }
    @SuppressLint("MissingPermission")
    private fun geolocalizar() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        fusedLocationClient.lastLocation.addOnSuccessListener {
            if(it != null)
                imprimirUbicacion(it)
        }
    }

    private fun imprimirUbicacion(ubicacion: Location) {
        Toast.makeText(context, "${ubicacion.latitude}, ${ubicacion.longitude}",
            Toast.LENGTH_SHORT).show()
        binding.latitud.text = getString(R.string.latitud, ubicacion.latitude)
        binding.longitud.text = getString(R.string.longitud, ubicacion.longitude)
        binding.direccion.text = buscarDireccion(ubicacion)
    }

    private val peticionPermisos =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){permissions ->

        val aceptados = permissions.entries.all {
            Toast.makeText(context, "${it.key} = ${it.value}", Toast.LENGTH_SHORT).show()
            it.value
        }
            if (aceptados)
                geolocalizar()

        }

    private fun solicitarPermisos(permisos: Array<String>) {
        peticionPermisos.launch(permisos)
    }

    private fun tienePermisos(permisos: Array<String>): Boolean {
        return permisos.all {
            return  ContextCompat.checkSelfPermission(
                requireContext(),
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
    private fun buscarDireccion(ubicacion: Location): String
    {
        val geocoder = context?.let { Geocoder(it, Locale.getDefault()) }

        val direcciones = geocoder?.getFromLocation(
            ubicacion.latitude, ubicacion.longitude, 1
        )

        if (direcciones != null) {
            if (direcciones.isNotEmpty()) {
                val direccion = direcciones.first()
                val textoDireccion =
                    (0..direccion.maxAddressLineIndex)
                        .joinToString("\n") { i -> direccion.getAddressLine(i) }
                return textoDireccion
            }
        }
            return ""
    }
    @SuppressLint("MissingPermission")
    private fun geolocalizacionConstante()
    {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,
            10000).build()
        locationCallback = object : LocationCallback()
        {
            override fun onLocationResult(p0: LocationResult) {
                for (location in p0.locations)
                    imprimirUbicacion(location)
            }
        }
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback, Looper.getMainLooper()
        )
    }
}