package com.example.android.Model.Local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.Model.Local.Entities.DetalleLocal
import com.example.android.Model.Local.Entities.ListaLocal
/**(Data Access Object = DAO) permite el acceso a la base de datos
 * @author Loredana Piras A.* */

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllListas(listaLocal: List<ListaLocal>)

    @Query("SELECT * FROM Lista_Clima ORDER BY id ASC")
    fun getAllListas(): LiveData<List<ListaLocal>>//live dsta para observar los resultados

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetalleLocal(detalleLocal: DetalleLocal)

    @Query("SELECT * FROM Detalle_Clima WHERE id = :id")
    fun getDetalleLocalById(id: Int): LiveData<DetalleLocal>



}