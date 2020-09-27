package com.example.postsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.postsapp.models.Comment
import com.example.postsapp.models.Post
import com.example.postsapp.models.ToDo

class PostAppDatabase {
    @Database(entities = arrayOf(Post::class , Comment::class,ToDo::class), version = 3)
    abstract class PostAppDatabase: RoomDatabase() {
        abstract fun postDao():PostsDao

        companion object{
            private var dbInstance:PostAppDatabase? = null

            fun getDBInstance(context: Context):PostAppDatabase{
                if(dbInstance==null){
                    dbInstance= Room.databaseBuilder(context,PostAppDatabase::class.java, "postsapp-db")
                        .fallbackToDestructiveMigration().build()
                }
                return dbInstance as PostAppDatabase
            }
        }

    }
}