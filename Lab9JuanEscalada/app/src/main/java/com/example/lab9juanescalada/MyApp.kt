package com.example.lab9juanescalada

import android.app.Application
import androidx.room.Room
import com.example.lab9juanescalada.data.AppDatabase
import com.example.lab9juanescalada.data.UsersRepository

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