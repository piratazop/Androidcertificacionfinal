package com.example.android.Model.Local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.Model.Local.Dao.Dao
import com.example.android.Model.Local.Entities.DetalleLocal
import com.example.android.Model.Local.Entities.ListaLocal

/** Base de datos Room permite guardar información
 * @author Loredana Piras A.* */


@Database(entities = [ListaLocal::class,DetalleLocal::class], version = 1, exportSchema = false)
    abstract class DatosDatabase : RoomDatabase(){

        abstract fun getDao(): Dao

        companion object {


            @Volatile
            private var INSTANCE: DatosDatabase? = null

            fun getdatabase(context: Context):DatosDatabase {

                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatosDatabase::class.java,
                        "datos_database"

                    ).build()
                    INSTANCE = instance
                    return instance

                }
            }
        }
    }




