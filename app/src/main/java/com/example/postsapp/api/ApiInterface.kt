package com.example.postsapp.api

import com.example.postsapp.models.Comment
import com.example.postsapp.models.Post
import com.example.postsapp.models.ToDo
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("comments")
    suspend fun getComments(): Response<List<Comment>>

    @GET("todos")
    suspend fun getToDo(): Response<List<ToDo>>


}