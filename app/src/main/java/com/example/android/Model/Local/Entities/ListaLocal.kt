package com.example.android.Model.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
/**Lista de elementos almacenados en la entidad local
 * @author Loredana Piras A.* */

@Entity(tableName = "Lista_Clima" )
data class ListaLocal (
    @PrimaryKey
    val id: Int,
    val ciudad: String,
    val region: String,
    val imagen: String,
    val temperatura: Int,
    val viento: Boolean,
    val amanecer: String,
    val atardecer: String,
    //val detalles_tiempo : DetallesTiempo




){


    /*data class DetallesTiempo(

        val pronostico : String,
        val siguientedia: String
    )*/
}