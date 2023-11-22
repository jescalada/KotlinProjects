package com.example.lab9juanescalada.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class LocalUser(
    @PrimaryKey (autoGenerate = true) val uid: Int? = null,
    val name: String,
    val email: String
)