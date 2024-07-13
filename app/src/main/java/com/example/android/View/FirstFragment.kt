package com.example.android.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.R
import com.example.android.ViewModel.ViewModel
import com.example.android.databinding.FragmentFirstBinding
import com.example.android.View.Adapter.Adapter

class FirstFragment : Fragment() {

    private  var _binding: FragmentFirstBinding?= null
    private val viewModel: ViewModel by activityViewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = Adapter()
        binding.RvList.adapter = adapter
        binding.RvList.layoutManager = GridLayoutManager(context, 2)

        //Adapter
        viewModel.getListaLocal().observe(viewLifecycleOwner) {

            it.let {
                Log.d("listadoid", it.toString())
                adapter.actualizar(it)
            }

        }
        adapter.selected().observe(viewLifecycleOwner) {
            it.let {
                Log.d("Seleccionado", it.toString())
                viewModel.getDetalleLocalByIdFromInternet(it.id)

            }
            val bundle = Bundle().apply {
                putInt("listadoId", it.id)

            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




