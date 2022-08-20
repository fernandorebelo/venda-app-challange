package com.example.venda_app_challange.UI

import com.example.venda_app_challange.Database.Entity.VendaEntity

interface DialogListener {
    fun onAddButtonClicked(venda: VendaEntity)
}