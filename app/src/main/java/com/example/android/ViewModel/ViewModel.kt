package com.example.android.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.Model.Local.Database.DatosDatabase
import com.example.android.Model.Local.Entities.DetalleLocal
import com.example.android.Model.Local.Entities.ListaLocal
import com.example.android.Model.Remoto.Repositorio
import kotlinx.coroutines.launch
/** Mantiene los datos y lógica de la interfaz
 * @author Loredana Piras A.* */
class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repositorio
    private var idSelected: Int = 0
    private val detalleLocal = MutableLiveData<DetalleLocal>()

    init {
        val bd = DatosDatabase.getdatabase(application)
        val Dao = bd.getDao()
        repository = Repositorio(Dao)
        viewModelScope.launch {
            repository.fetchLista()
        }
    }

    fun getListaLocal(): LiveData<List<ListaLocal>> = repository.listaLocalRepositorio


    fun getDetalleLocal(): LiveData<DetalleLocal> = detalleLocal

    fun getDetalleLocalByIdFromInternet(id: Int) = viewModelScope.launch {

        val detalle = repository.fetchDetalleLocal(id)
        detalle?.let {
            detalleLocal.postValue(it)
        }


    }




}
