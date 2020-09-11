package com.example.postsapp.repository

import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO){
        val apiInterface=ApiClient.buildService(ApiInterface::class.java)
        val response= apiInterface.getPosts()
        return@withContext response
    }




}