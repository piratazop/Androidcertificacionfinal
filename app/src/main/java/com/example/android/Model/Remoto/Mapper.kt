package com.example.android.Model.Remoto

import com.example.android.Model.Local.Entities.DetalleLocal
import com.example.android.Model.Local.Entities.ListaLocal
import com.example.android.Model.Remoto.FromInternet.DetalleInternet
import com.example.android.Model.Remoto.FromInternet.ListaInternet

/** Permite convertir los datos obtenidos de internet a una lista local
 * @author Loredana Piras A.* */

fun fromInternetListaInternet(listaLocal: List<ListaInternet>): List<ListaLocal> {

    return listaLocal.map {
        ListaLocal(
            id = it.id,
            ciudad = it.ciudad,
            region = it.region,
            imagen = it.imagen,
            temperatura= it.temperatura,
            viento = it.viento,
            amanecer = it.amanecer,
            atardecer = it.atardecer
            /*detalles_tiempo = it.detalles_tiempo
            ListaLocal.DetallesTiempo(
                pronostico = it.detalles_tiempo.pronostico,
                siguientedia = it.detalles_tiempo.siguientedia
            )*/





        )




    }
}

fun fromInternetDetalleInternet(detalle: DetalleInternet):DetalleLocal{

    return DetalleLocal(

        id = detalle.id,
        ciudad = detalle.ciudad,
        region = detalle.region,
        imagen = detalle.imagen,
        temperatura= detalle.temperatura,
        viento = detalle.viento,
        amanecer = detalle.amanecer,
        atardecer = detalle.atardecer
        /*detalles_tiempo = DetalleLocal.DetallesTiempo(
            pronostico = detalle.detalles_tiempo.pronostico,
            siguientedia = detalle.detalles_tiempo.siguientedia
        )*/
    )


}