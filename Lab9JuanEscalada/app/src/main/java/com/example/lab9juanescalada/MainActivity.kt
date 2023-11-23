package com.example.lab9juanescalada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.lab9juanescalada.ui.main.UsersState
import com.example.lab9juanescalada.ui.main.MainContent

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