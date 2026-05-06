package com.treinamentomobile.crudapi.model

data class Contact(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val birthday: String,
    val cep: String,
    val street: String,
    val number: String,
    val complement: String,
    val neighborhood: String,
    val city: String,
    val state: String
)
