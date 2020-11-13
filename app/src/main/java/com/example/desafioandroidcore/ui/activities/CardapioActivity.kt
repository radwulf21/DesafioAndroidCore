package com.example.desafioandroidcore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Prato
import com.example.desafioandroidcore.ui.adapters.PratosAdapter
import kotlinx.android.synthetic.main.activity_cardapio.*

class CardapioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardapio)

        setSupportActionBar(toolbar_cardapio)

        var imgRestaurante = intent.getSerializableExtra("imgRestaurante") as? Int
        var nomeRestaurante = intent.getSerializableExtra("nomeRestaurante") as? String
        var pratosRestaurante = intent.getParcelableArrayListExtra<Prato>("pratosRestaurante") as? ArrayList<Prato>

        var listPratos = pratosRestaurante
        var adapter = listPratos?.let { PratosAdapter(it) }

        imgRestaurante?.let { iv_restaurant.setImageResource(it) }
        tv_nome_restaurant.text = nomeRestaurante

        rv_pratos.adapter = adapter
        rv_pratos.layoutManager = LinearLayoutManager(this)
        rv_pratos.setHasFixedSize(true)
    }
}