package com.example.lecture10.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {
    // Unpack the user into name and email
    // Insert the user into the database
    @Query("INSERT INTO users (name, email) VALUES (:name, :email)")
    fun insertUser(name: String, email: String)
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<LocalUser>
    @Query("SELECT * FROM users WHERE uid = :id")
    fun getUser(id: Int): LocalUser
    @Query("DELETE FROM users WHERE uid = :id")
    fun deleteUser(id: Int)
}