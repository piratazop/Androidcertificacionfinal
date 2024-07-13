package com.example.android.Model.Remoto.FromInternet

/**POJO representa los detalles de una lista obtenidos de una fuente remota
 * @author Loredana Piras A.* */
data class DetalleInternet (
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
