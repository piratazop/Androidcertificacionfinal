package com.example.android.Model.Remoto

import com.example.android.Model.Remoto.FromInternet.DetalleInternet
import com.example.android.Model.Remoto.FromInternet.ListaInternet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/** Interfaz define dos métodos para obtener información:
 * uno para obtener la lista completa y otro para obtener detalles específicos por ID
 * @author Loredana Piras A.* */

interface Api {
   @GET("data")
   suspend fun fetchListaInternet(): Response<List<ListaInternet>>




   @GET("data/{id}")
   suspend fun fetchDetalleInternet(@Path("id") id: Int): Response<DetalleInternet>


}