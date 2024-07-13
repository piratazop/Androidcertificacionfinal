package com.example.android.View.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.Model.Local.Entities.ListaLocal
import com.example.android.databinding.ListBinding
/** Permite mostrar los elementos de la lista en un RecyclerView
 * @author Loredana Piras A.* */

    class Adapter: RecyclerView.Adapter<Adapter.Viewholder>() {

        private var listaLocal = listOf<ListaLocal>()
        private val selectedListado = MutableLiveData<ListaLocal>()

        fun selected(): LiveData<ListaLocal> = selectedListado


        inner class Viewholder (private val binding: ListBinding) :
            RecyclerView.ViewHolder(binding.root),
            View.OnClickListener {
            fun bind (servicios: ListaLocal) {
                Glide.with(binding.imageRv).load(servicios.imagen).centerCrop()
                    .into(binding.imageRv)
                binding.textNameRV.text = servicios.ciudad
                binding.textTipoRV.text = servicios.region
                itemView.setOnClickListener(this)

            }

            override fun onClick(v: View?) {
                selectedListado.value = listaLocal[adapterPosition]

            }

        }

        fun actualizar(list: List<ListaLocal>) {
            listaLocal = list
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
            return Viewholder(ListBinding.inflate(LayoutInflater.from(parent.context)))
        }

        override fun onBindViewHolder(holder: Viewholder, position: Int) {
            holder.bind(listaLocal[position])
        }


        override fun getItemCount(): Int = listaLocal.size


    }





