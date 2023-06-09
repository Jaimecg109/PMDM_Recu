package es.jaimedecos.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import es.jaimedecos.app_ut2_06.databinding.FragmentFechaBinding
import es.jaimedecos.app_ut2_06.databinding.FragmentResumenBinding

class FragmentResumen : Fragment() {

    private lateinit var binding : FragmentResumenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResumenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonReservar.setOnClickListener {
            Toast.makeText(activity,"Se ha realizado la reserva", Toast.LENGTH_SHORT).show()
        }

    }


}