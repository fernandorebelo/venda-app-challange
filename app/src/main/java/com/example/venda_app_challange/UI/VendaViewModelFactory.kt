package com.example.venda_app_challange.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.venda_app_challange.Database.VendaRepository

class VendaViewModelFactory(private val repository: VendaRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VendaViewModel(repository) as T
    }

}