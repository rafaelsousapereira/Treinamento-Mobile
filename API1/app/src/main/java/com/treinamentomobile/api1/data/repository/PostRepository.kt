package com.treinamentomobile.api1.data.repository

import com.treinamentomobile.api1.data.model.Post
import com.treinamentomobile.api1.data.remote.RetrofitClient

class PostRepository {

    suspend fun getPost(): List<Post> {
        return RetrofitClient.api.getPosts()
    }
}