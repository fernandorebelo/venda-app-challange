package com.example.venda_app_challange.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.venda_app_challange.Database.Entity.VendaEntity

/*
Database: é a representação da classe abstrata do Banco de Dados.
Esta receberá uma anotação que irá identificar as Entities, os Dao’s e seus Converters.
Ele será responsável por fazer o controle do banco de dados.
 */

@Database(entities = [VendaEntity::class], version = 1)
abstract class VendaDatabase : RoomDatabase(){
    abstract fun getVendaDao(): VendaDao

    companion object {
        @Volatile
        private var instance: VendaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, VendaDatabase::class.java, "VendaDatabase.db").build()
    }
}