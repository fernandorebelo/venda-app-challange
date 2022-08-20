package com.example.venda_app_challange.UI

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.venda_app_challange.Database.Entity.VendaEntity
import com.example.venda_app_challange.R

class VendaDialog(context: Context, var dialogListener: DialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.vendadialog)

        val botaoCadastrarVenda = findViewById<Button>(R.id.tvSave)
        val botaoCancelar = findViewById<TextView>(R.id.tvCancel)
        val txtValor = findViewById<EditText>(R.id.etValorVenda)


        botaoCadastrarVenda?.setOnClickListener{
            val valor = txtValor?.text.toString()

            if (valor.isEmpty()) {
                Toast.makeText(context, "Entre o valor", Toast.LENGTH_SHORT).show()
            }

            val item = VendaEntity(valor)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }
        botaoCancelar?.setOnClickListener {
            cancel()
        }
    }

}