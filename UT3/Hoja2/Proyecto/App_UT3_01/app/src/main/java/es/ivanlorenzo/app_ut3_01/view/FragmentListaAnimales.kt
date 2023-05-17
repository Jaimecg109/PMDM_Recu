package es.ivanlorenzo.app_ut3_01.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.ivanlorenzo.app_ut3_01.databinding.FragmentListaAnimalesBinding
import es.ivanlorenzo.app_ut3_01.model.Animal
import es.ivanlorenzo.app_ut3_01.viewmodel.AnimalViewModel

class FragmentListaAnimales : Fragment()
{
    private lateinit var binding: FragmentListaAnimalesBinding
    private val animalViewModel: AnimalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        binding = FragmentListaAnimalesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        animalViewModel.cargarDatos()

        animalViewModel.animalesLiveData.observe(viewLifecycleOwner) { animales ->
            with (binding.recyclerViewAnimales){
                adapter = AnimalAdapter(animales){ animal -> onClickAnimal(animal)}
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        animalViewModel.estaCargandoLiveData.observe(viewLifecycleOwner){estaCargando ->
            binding.progressBarCargaAnimales.isVisible = estaCargando
            binding.recyclerViewAnimales.isVisible = !estaCargando
        }


    }

    private fun onClickAnimal(animal: Animal)
    {
        //Toast.makeText(this, animal.descripcion, Toast.LENGTH_LONG).show()
        val intent = Intent(context, DetalleAnimalActivity::class.java)
        intent.putExtra("animal", animal)
        segundaActivityLauncher.launch(intent)
    }


    private val segundaActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == Activity.RESULT_OK){
                val voto = it.data?.getIntExtra("voto", 0)?:0
                val nombre = it.data?.getStringExtra("animal")?:""
                animalViewModel.cambiarVoto(nombre, voto)
            }
        }


}