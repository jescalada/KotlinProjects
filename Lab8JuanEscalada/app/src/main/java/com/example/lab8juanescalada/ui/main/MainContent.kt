package com.example.lab8juanescalada.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

enum class Screen(val route: String) {
    HOME("home"),
    INFO("info")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    val navController = rememberNavController()

    // Add mutable state for current selected color
    val currentColorHex = remember { mutableLongStateOf(0L) }

    Scaffold(
        topBar = {
            MyTopBar(navController = navController, currentColorHex)
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = Screen.HOME.route,
            modifier = Modifier.padding(it)
        )
        {
            composable(route = Screen.HOME.route) {
                Home(navController = navController, currentColorHex = currentColorHex)
            }
            composable(
                route = "info/{colorHex}",
                arguments = listOf(navArgument("colorHex") {
                    type = NavType.LongType
                })
            ) {
                val colorHex = it.arguments?.getLong("colorHex")
                Info(colorHex)
            }
        }
    }
}