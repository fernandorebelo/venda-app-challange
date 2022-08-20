package com.example.venda_app_challange.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.venda_app_challange.Database.Entity.VendaEntity

/*
Dao (Data Access Object): são as interfaces utilizadas para acessar os dados armazenados no banco.
 */

@Dao
interface VendaDao {

    @Query("SELECT * FROM vendas")
    fun getAllVendas(): LiveData<List<VendaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenda(vendas: VendaEntity)

    @Update
    suspend fun updateVenda(venda: VendaEntity)

    @Delete
    suspend fun deleteVenda(venda: VendaEntity)

    @Query("DELETE FROM vendas")
    suspend fun deleteAll()
}