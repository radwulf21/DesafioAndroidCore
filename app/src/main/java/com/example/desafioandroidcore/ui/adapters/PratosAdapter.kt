package com.example.desafioandroidcore.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Prato
import com.example.desafioandroidcore.ui.activities.CardapioActivity

class PratosAdapter(private val listPratos: ArrayList<Prato>, var listener: OnClickPratoListener): RecyclerView.Adapter<PratosAdapter.PratosViewHolder>() {
    inner class PratosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var iv_prato: ImageView = itemView.findViewById(R.id.iv_prato)
        var tv_nome_prato: TextView = itemView.findViewById(R.id.tv_nome_prato)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickPrato(position)
            }
        }
    }

    interface OnClickPratoListener {
        fun onClickPrato(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_prato, parent, false)
        return PratosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratosViewHolder, position: Int) {
        var prato = listPratos[position]
        holder.iv_prato.setImageResource(prato.img)
        holder.tv_nome_prato.text = prato.nome
    }

    override fun getItemCount() = listPratos.size
}