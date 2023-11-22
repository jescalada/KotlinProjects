package com.example.lecture10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.lecture10.ui.main.MainContent
import com.example.lecture10.ui.main.UsersState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usersRepository = (application as MyApp).usersRepository
        setContent {
            val usersState = remember {
                UsersState(usersRepository)
            }
            MainContent(usersState)
        }
    }
}