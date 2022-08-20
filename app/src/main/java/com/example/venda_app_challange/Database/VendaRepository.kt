package com.example.venda_app_challange.Database

import com.example.venda_app_challange.Database.Entity.VendaEntity

class VendaRepository(private val db: VendaDatabase) {
    suspend fun insert(venda: VendaEntity) = db.getVendaDao().insertVenda(venda)
    suspend fun delete(venda: VendaEntity) = db.getVendaDao().deleteVenda(venda)

    fun allVendas() = db.getVendaDao().getAllVendas()
}