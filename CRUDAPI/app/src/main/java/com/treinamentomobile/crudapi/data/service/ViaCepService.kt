package com.treinamentomobile.crudapi.data.service

import com.treinamentomobile.crudapi.data.model.ViaCepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): ViaCepResponse
}