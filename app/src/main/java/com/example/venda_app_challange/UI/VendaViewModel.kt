package com.example.venda_app_challange.UI

import androidx.lifecycle.ViewModel
import com.example.venda_app_challange.Database.Entity.VendaEntity
import com.example.venda_app_challange.Database.VendaRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VendaViewModel(private val repository: VendaRepository) : ViewModel(){

    fun insert(venda: VendaEntity) = GlobalScope.launch {
        repository.insert(venda)
    }

    fun delete(venda: VendaEntity) = GlobalScope.launch {
        repository.delete(venda)
    }

    fun allVendas() = repository.allVendas()

}