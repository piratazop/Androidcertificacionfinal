package com.example.android.Model.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**Detalles de la lista almacenados en la entidad local
 * @author Loredana Piras A.* */

@Entity(tableName = "Detalle_Clima" )
data class DetalleLocal(

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