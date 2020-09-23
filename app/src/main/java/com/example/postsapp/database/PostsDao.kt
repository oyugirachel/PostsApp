package com.example.postsapp.database

import androidx.lifecycle.LiveDataScope
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postsapp.models.Post

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(post: Post)

    @Query("SELECT * FROM posts")
    fun getPosts(): LiveDataScope<List<Post>>
}
