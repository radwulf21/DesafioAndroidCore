package com.example.desafioandroidcore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Restaurant
import com.example.desafioandroidcore.ui.adapters.RestaurantsAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    var listRestaurants = getAllRestaurants()
    var adapter = RestaurantsAdapter(listRestaurants)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_restaurants.adapter = adapter
        rv_restaurants.layoutManager = LinearLayoutManager(this)
        rv_restaurants.setHasFixedSize(true)
    }

    private fun getAllRestaurants(): ArrayList<Restaurant> {
        val restaurant1 = Restaurant(
            1,
            R.drawable.image1,
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00"
        )

        val restaurant2 = Restaurant(
            2,
            R.drawable.image4,
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00"
        )

        val restaurant3 = Restaurant(
            3,
            R.drawable.image2,
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00"
        )

        val restaurant4 = Restaurant(
            4,
            R.drawable.image3,
            "Sí Señor!",
            "Alemeda Jauaperi, 626 - Moema",
            "Fecha às 01:00"
        )

        return arrayListOf(restaurant1, restaurant2, restaurant3, restaurant4)
    }
}