package com.example.postsapp.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postsapp.models.Comment
import com.example.postsapp.models.Post

@Dao
interface CommentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: Comment)

    @Query("SELECT * FROM comments")
    fun getComments(): LiveDataScope<List<Comment>>

    @Query("SELECT * FROM comments WHERE id = :postId")
    fun getPostById(postId:Int): LiveData<Comment>
}