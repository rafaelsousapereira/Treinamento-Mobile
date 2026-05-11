package com.treinamentomobile.crudapi.data.model

import com.google.gson.annotations.SerializedName

data class ViaCepResponse(
    val cep: String,
    @SerializedName("logradouro") val street: String,
    @SerializedName("complemento") val complement: String,
    @SerializedName("bairro") val neighborhood: String,
    @SerializedName("localidade") val city: String,
    @SerializedName("uf") val state: String
)