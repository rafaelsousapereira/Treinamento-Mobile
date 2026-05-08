package com.treinamentomobile.crudapi.data.model

import java.util.Date

data class Contact(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val birthday: Date,
    val cep: String,
    val street: String,
    val number: Int,
    val complement: String,
    val neighborhood: String,
    val city: String,
    val state: String
)