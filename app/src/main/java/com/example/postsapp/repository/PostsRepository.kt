package com.example.postsapp.repository

import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.database.PostAppDatabase
import com.example.postsapp.database.PostAppDatabase.PostAppDatabase.Companion.getDBInstance
import com.example.postsapp.models.Post
import com.example.postsapp.viewmodel.PostsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Handshake.Companion.get
import retrofit2.Response

class PostsRepository {
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO) {
        val apiInterface = ApiClient.buildService(ApiInterface::class.java)
        val response = apiInterface.getPosts()
        if(response.isSuccessful){

        }
        return@withContext response
    }

    suspend fun savePosts(postList: List<Post>) = withContext(Dispatchers.IO) {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
       postList.forEach {
           database.postDao().InsertPost(post)
       }

        }
    }


}