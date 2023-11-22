package com.example.lecture10.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class LocalUser(
    @PrimaryKey (autoGenerate = true) val uid: Int? = null,
    val name: String,
    val email: String
)