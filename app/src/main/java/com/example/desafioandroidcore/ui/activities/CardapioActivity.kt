package com.example.desafioandroidcore.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Prato
import com.example.desafioandroidcore.ui.adapters.PratosAdapter
import kotlinx.android.synthetic.main.activity_cardapio.*

class CardapioActivity : AppCompatActivity(), PratosAdapter.OnClickPratoListener {
    var pratos = arrayListOf<Prato>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardapio)

        setSupportActionBar(toolbar_cardapio)

        val imgRestaurante = intent.getSerializableExtra("imgRestaurante") as? Int
        val nomeRestaurante = intent.getSerializableExtra("nomeRestaurante") as? String
        val pratosRestaurante = intent.getParcelableArrayListExtra<Prato>("pratosRestaurante") as? ArrayList<Prato>

        if (pratosRestaurante != null) {
            pratos = pratosRestaurante
        }

        val listPratos = pratosRestaurante
        val adapter = listPratos?.let { PratosAdapter(it, this) }

        imgRestaurante?.let { iv_restaurant.setImageResource(it) }
        tv_nome_restaurant.text = nomeRestaurante

        rv_pratos.adapter = adapter
        rv_pratos.layoutManager = GridLayoutManager(this, 2)
        rv_pratos.setHasFixedSize(true)
    }

    override fun onClickPrato(position: Int) {
        val prato = pratos[position]
        var imgPrato = prato.img
        var nomePrato = prato.nome
        var descricaoPrato = prato.descricao

        val intent = Intent(this, DetalhesPratoActivity::class.java)
        intent.putExtra("imgPrato", imgPrato)
        intent.putExtra("nomePrato", nomePrato)
        intent.putExtra("descricaoPrato", descricaoPrato)
        startActivity(intent)
    }
}