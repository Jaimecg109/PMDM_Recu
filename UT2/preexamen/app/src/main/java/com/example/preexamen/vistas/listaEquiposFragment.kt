package com.example.preexamen.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.preexamen.R
import com.example.preexamen.ViewModel.EquiposViewModel
import com.example.preexamen.databinding.FragmentListaEquiposBinding


class listaEquiposFragment : Fragment() {

    private lateinit var binding: FragmentListaEquiposBinding
    private val viewModel: EquiposViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaEquiposBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    /*
        viewModel.listaEquipos.observe(viewLifecycleOwner){
            binding.apply {
                listaEquipos.adapter = EquiposAdapter(viewModel)
                listaEquipos.layoutManager = LinearLayoutManager(context)
                listaEquipos.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
        viewModel.cargarEquipos();
     */
        viewModel.cargarEquipos()
        binding.listaEquipos.adapter = EquiposAdapter(viewModel)
        binding.listaEquipos.layoutManager = LinearLayoutManager(context)
        binding.listaEquipos.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    }

}