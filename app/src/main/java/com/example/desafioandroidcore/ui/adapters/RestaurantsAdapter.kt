package com.example.desafioandroidcore.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Restaurant

class RestaurantsAdapter(private val listRestaurants: ArrayList<Restaurant>, var listener: OnClickRestaurantListener): RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {
    inner class RestaurantsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var iv_restaurant: ImageView = itemView.findViewById(R.id.iv_restaurant)
        var tv_nome_restaurant: TextView = itemView.findViewById(R.id.tv_nome_restaurant)
        var tv_endereço: TextView = itemView.findViewById(R.id.tv_endereço)
        var tv_horario_fechamento: TextView = itemView.findViewById(R.id.tv_horario_fechamento)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickRestaurant(position)
            }
        }
    }

    interface OnClickRestaurantListener {
        fun onClickRestaurant(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        var restaurant = listRestaurants[position]
        holder.iv_restaurant.setImageResource(restaurant.img)
        holder.tv_nome_restaurant.text = restaurant.nome
        holder.tv_endereço.text = restaurant.endereco
        holder.tv_horario_fechamento.text = restaurant.horarioFechamento
    }

    override fun getItemCount() = listRestaurants.size
}