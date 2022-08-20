package com.example.venda_app_challange

import android.app.Application
import androidx.room.Room
import com.example.venda_app_challange.Database.VendaDatabase
import com.facebook.stetho.Stetho

open class MyApplication : Application(){
    companion object {
        var database: VendaDatabase? = null
    }


    override fun onCreate() {
        super.onCreate()
        //Room
        database = Room.databaseBuilder(this, VendaDatabase::class.java, "my-db").allowMainThreadQueries().build()

//        Stetho
        val initializerBuilder = Stetho.newInitializerBuilder(this)
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        val initializer = initializerBuilder.build()
        Stetho.initialize(initializer)
    }
}