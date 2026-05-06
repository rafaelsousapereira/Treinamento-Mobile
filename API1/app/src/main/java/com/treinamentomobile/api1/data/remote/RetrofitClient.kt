package com.treinamentomobile.api1.data.remote

import com.treinamentomobile.api1.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // URL da API
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Instância da API
    val api: ApiService by lazy {
        // Build - Configurar acesso para API
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Disponibilizar a URL da API
            .addConverterFactory(GsonConverterFactory.create()) // Tipo de informação que será enviada (JSON, XML, etc)
            .build() // Construir a API
            .create(ApiService::class.java) // Criar a API
    }

}