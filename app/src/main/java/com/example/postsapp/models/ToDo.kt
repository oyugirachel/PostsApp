package com.example.postsapp.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todos")
data class ToDo(
    val completed: Boolean,
    @PrimaryKey @NonNull val id: Int,
    val title: String,
    val userId: Int
)