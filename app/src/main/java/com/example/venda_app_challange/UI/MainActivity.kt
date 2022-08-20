package com.example.venda_app_challange.UI

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.venda_app_challange.Adapter.VendaAdapter
import com.example.venda_app_challange.Database.Entity.VendaEntity
import com.example.venda_app_challange.Database.VendaDatabase
import com.example.venda_app_challange.Database.VendaRepository
import com.example.venda_app_challange.R

private val newVendaActivityRequestCode = 1

class MainActivity : AppCompatActivity() {

    lateinit var ViewModel: VendaViewModel
    lateinit var list: List<VendaEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val vendaRepository = VendaRepository(VendaDatabase(this))
        val factory = VendaViewModelFactory(vendaRepository)
        val lista = findViewById<RecyclerView>(R.id.rvList)

        // Initialised View Model
        ViewModel = ViewModelProvider(this, factory).get(VendaViewModel::class.java)
        val vendaAdapter = VendaAdapter(listOf(), ViewModel)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = vendaAdapter

        // To display all items in recycler view
        ViewModel.allVendas().observe(this, Observer{
            vendaAdapter.list = it
            vendaAdapter.notifyDataSetChanged()
        })


        val botaoTelaVenda = findViewById<Button>(R.id.botaoTelaVenda)

        botaoTelaVenda.setOnClickListener{
            VendaDialog(this, object : DialogListener {
                override fun onAddButtonClicked(venda: VendaEntity){
                    ViewModel.insert(venda)
                }
            }).show()
        }
    }
}