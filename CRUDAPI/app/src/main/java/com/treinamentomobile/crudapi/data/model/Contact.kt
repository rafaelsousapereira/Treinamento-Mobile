package com.treinamentomobile.crudapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val phone: String,
    val birthday: Date,
    val cep: String? = null,
    val street: String,
    val number: Int,
    val complement: String,
    val neighborhood: String,
    val city: String,
    val state: String
)