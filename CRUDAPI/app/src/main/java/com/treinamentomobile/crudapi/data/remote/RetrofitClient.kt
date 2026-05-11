package com.treinamentomobile.crudapi.data.remote

import com.treinamentomobile.crudapi.data.service.ViaCepService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val VIACEP_BASE_URL = "https://viacep.com.br/ws/"

    val api: ViaCepService by lazy {
        Retrofit.Builder()
            .baseUrl(VIACEP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViaCepService::class.java)
    }
}