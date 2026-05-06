package com.treinamentomobile.api1.service

import com.treinamentomobile.api1.data.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}