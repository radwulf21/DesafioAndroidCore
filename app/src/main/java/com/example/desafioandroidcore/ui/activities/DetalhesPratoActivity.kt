package com.example.desafioandroidcore.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.domain.Prato
import kotlinx.android.synthetic.main.activity_detalhes_prato.*

class DetalhesPratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_prato)

        val imgPrato = intent.getSerializableExtra("imgPrato") as? Int
        val nomePrato = intent.getSerializableExtra("nomePrato") as? String
        val descricaoPrato = intent.getSerializableExtra("descricaoPrato") as? String

        imgPrato?.let { iv_prato.setImageResource(it) }
        tv_nome_prato.text = nomePrato
        tv_descricao_prato.text = descricaoPrato
    }
}