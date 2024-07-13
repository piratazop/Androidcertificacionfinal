package com.example.android.Model.Remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/** Configura y proporciona una instancia para hacer solicitudes a internet
 * @author Loredana Piras A.* */
class Retrofit {

    companion object {

        private const val BASE_URL = "https://tiempo-e38el7dv5-talento-projects.vercel.app/"

        lateinit var retrofitInstance: Retrofit
        fun getRetrofit(): Api {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
            return retrofit.create(Api::class.java)
        }
    }



}