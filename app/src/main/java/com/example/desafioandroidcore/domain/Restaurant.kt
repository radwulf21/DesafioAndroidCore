package com.example.desafioandroidcore.domain

data class Restaurant(val id: Int, var img: Int, var nome: String, var endereco: String, var horarioFechamento: String, var pratos: ArrayList<Prato>)