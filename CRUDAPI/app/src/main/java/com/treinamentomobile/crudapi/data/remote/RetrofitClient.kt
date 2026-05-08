package com.treinamentomobile.crudapi.data.remote

import com.treinamentomobile.crudapi.data.service.ContactService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://viacep.com.br/"

    val api: ContactService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ContactService::class.java)
    }
}