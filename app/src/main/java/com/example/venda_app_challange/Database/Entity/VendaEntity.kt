package com.example.venda_app_challange.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Entity: são entidades responsáveis por mapear as tabelas.
 */

@Entity(tableName = "vendas")
data class VendaEntity(
    @ColumnInfo(name = "valor")
    val valor: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
