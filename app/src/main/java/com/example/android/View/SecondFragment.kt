package com.example.android.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.android.ViewModel.ViewModel
import com.example.android.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel: ViewModel by activityViewModels()
    private var listadoId: Int? = null


    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            listadoId = bundle.getInt("listaId")
            Log.d("Seleccion SegFragment", listadoId.toString())


        }

        listadoId?.let {id->
            viewModel.getDetalleLocalByIdFromInternet(id)

        }

        viewModel.getDetalleLocal().observe(viewLifecycleOwner, Observer {
            Log.d("Seleccion Fragmento2", listadoId.toString())

            Glide.with(binding.imgeRv).load(it.imagen).into(binding.imgeRv)

            //val entrada = it.siguientedia

            binding.txtCiudad .text = it.ciudad
            binding.txtRegion .text = "Fecha:${it.region}"
            binding.txttemperatura .text = "Lugar:${it.temperatura}"
            binding.txtViento .text = "Ciudad:${it.viento}"

            // Url de entradas
            binding.fab.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    //data = Uri.parse()
                }

                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                }
            }


        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}