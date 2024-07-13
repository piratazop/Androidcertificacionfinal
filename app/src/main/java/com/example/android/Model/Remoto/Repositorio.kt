package com.example.android.Model.Remoto

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.Model.Local.Dao.Dao
import com.example.android.Model.Local.Entities.DetalleLocal
import com.example.android.Model.Local.Entities.ListaLocal
/** Controla y almacena el historial de cambios y modificaciones del proyecto
 * @author Loredana Piras A.* */

class Repositorio(private val Dao: Dao) { //propiedad privada Dao que pasa como parámetro a l constructor

        //Inicializa instancia networkService utilizando la clase Retrofit
        private val networkService = Retrofit.getRetrofit()

        //Lista de elementos obtenidos desde el Dao
        val listaLocalRepositorio = Dao.getAllListas()

        //Detalle, objeto mutable
        val detalleLocal = MutableLiveData<DetalleLocal>()

        //Listado, objeto mutable
        val listaLocal = MutableLiveData<ListaLocal>()


    //fetchLista método suspendido que obtiene una lista de elementos desde internet
    // Utiliza networkService para hacer la solicitud

        suspend fun fetchLista() {
            val service = kotlin.runCatching { networkService.fetchListaInternet()}
            service.onSuccess {

                when (it.code()) {
                    in 200..299 -> it.body()?.let {

                        Log.d("Detalles", it.toString())

                       Dao.insertAllListas(fromInternetListaInternet(it))
                    }

                    else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
                }


            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }
        }
    //fetchDetalleLocal método suspendido que obtiene un detalle de un elemento por ID
    //Realiza una solicitud a internet para obtener detalles, si la respuesta es exitosa
    //convierte los detalles en un objeto local y lo inserta en el Dao.

        suspend fun fetchDetalleLocal(id:Int):DetalleLocal?{
            val service = kotlin.runCatching { networkService.fetchDetalleInternet(id)}

            return service.getOrNull()?.body()?.let {details ->

                val detalleLocal = fromInternetDetalleInternet(details)
               Dao.insertDetalleLocal(detalleLocal)
                detalleLocal
            }
        }
    //getDetalleLocalById método que devuelve un LiveData con el detalle de un elemento por ID
        fun getDetalleLocalById(id:Int): LiveData<DetalleLocal> {
            return Dao.getDetalleLocalById(id)

        }









}