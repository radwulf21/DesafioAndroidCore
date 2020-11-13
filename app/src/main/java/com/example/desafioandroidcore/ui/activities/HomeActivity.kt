package com.example.desafioandroidcore.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Prato
import com.example.desafioandroidcore.domain.Restaurant
import com.example.desafioandroidcore.ui.adapters.RestaurantsAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), RestaurantsAdapter.OnClickRestaurantListener {
    var listRestaurants = getAllRestaurants()
    var adapter = RestaurantsAdapter(listRestaurants, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_restaurants.adapter = adapter
        rv_restaurants.layoutManager = LinearLayoutManager(this)
        rv_restaurants.setHasFixedSize(true)
    }

    private fun getAllRestaurants(): ArrayList<Restaurant> {
        var pratosRestaurantes = getAllPratos()

        val restaurant1 = Restaurant(
            1,
            R.drawable.image1,
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00",
            pratosRestaurantes[0]
        )


        val restaurant2 = Restaurant(
            2,
            R.drawable.image4,
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00",
            pratosRestaurantes[1]
        )

        val restaurant3 = Restaurant(
            3,
            R.drawable.image2,
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00",
            pratosRestaurantes[2]
        )

        val restaurant4 = Restaurant(
            4,
            R.drawable.image3,
            "Sí Señor!",
            "Alemeda Jauaperi, 626 - Moema",
            "Fecha às 01:00",
            pratosRestaurantes[3]
        )

        return arrayListOf(restaurant1, restaurant2, restaurant3, restaurant4)
    }

    private fun getAllPratos(): ArrayList<ArrayList<Prato>> {
        var pratosRestaurant1 = arrayListOf<Prato>()
        for (i in 1..10) {
            val prato = Prato(i, R.drawable.image4, "Salada com molho Gengibre", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
            pratosRestaurant1.add(prato)
        }

        var pratosRestaurant2 = arrayListOf<Prato>()
        for (i in 1..10) {
            val prato = Prato(i, R.drawable.image1, "Camarão ao alho", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
            pratosRestaurant2.add(prato)
        }

        var pratosRestaurant3 = arrayListOf<Prato>()
        for (i in 1..10) {
            val prato = Prato(i, R.drawable.image3, "Ovos com pimenta do reino", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
            pratosRestaurant3.add(prato)
        }

        var pratosRestaurant4 = arrayListOf<Prato>()
        for (i in 1..10) {
            val prato = Prato(i, R.drawable.image2, "Sopa Gourmet", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
            pratosRestaurant4.add(prato)
        }

        return arrayListOf(pratosRestaurant1, pratosRestaurant2, pratosRestaurant3, pratosRestaurant4)
    }

    override fun onClickRestaurant(position: Int) {
        val restaurante = listRestaurants[position]

        val imgRestautante = restaurante.img
        val nomeRestaurante = restaurante.nome
        val pratosRestaurante = restaurante.pratos

        val intent = Intent(this, CardapioActivity::class.java)
        intent.putExtra("imgRestaurante", imgRestautante)
        intent.putExtra("nomeRestaurante", nomeRestaurante)
        intent.putParcelableArrayListExtra("pratosRestaurante", pratosRestaurante)
        startActivity(intent)
    }
}