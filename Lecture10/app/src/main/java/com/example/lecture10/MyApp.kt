package com.example.lecture10

import android.app.Application
import androidx.room.Room
import com.example.lecture10.data.AppDatabase
import com.example.lecture10.data.UsersRepository

class MyApp : Application() {
    private val db by lazy { Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "my-awesome-database")
        .allowMainThreadQueries()
        .build()
    }

    val usersRepository by lazy { UsersRepository(db.userDao()) }
}