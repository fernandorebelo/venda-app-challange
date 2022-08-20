package com.example.venda_app_challange.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.venda_app_challange.Database.Entity.VendaEntity
import com.example.venda_app_challange.R
import com.example.venda_app_challange.UI.VendaViewModel

class VendaAdapter(var list: List<VendaEntity>, val viewModel: VendaViewModel):RecyclerView.Adapter<VendaAdapter.VendaViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendaViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vendaadapter,
            parent, false)
        return VendaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VendaViewHolder, position: Int){
        var currentPosition = list[position]
//        holder.itemView.findViewById<EditText>(R.id.txtValorVenda).text = currentPosition.valor
        holder.itemView.findViewById<Button>(R.id.botaoExcluir).setOnClickListener{
            viewModel.delete(currentPosition)
        }

        if (position==list.size-1) {
            holder.itemView.findViewById<EditText>(R.id.txtValorVenda).visibility = View.VISIBLE
        }

    }




    inner class VendaViewHolder(vendaView: View) : RecyclerView.ViewHolder(vendaView)

}
