package com.example.lecture9.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

data class Character(val name: String, val imageId: Int)
data class NavItem(val navRoute: String, val icon: ImageVector, val title: String)
enum class Screen(val route: String) {
    HOME("home"),
    ABOUT("about"),
    MORE("more")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MyTopAppBar(navController = navController)
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) {

    NavHost(
        navController = navController,
        startDestination = Screen.HOME.route,
        modifier = Modifier.padding(it)
    )
    {
        composable(route = Screen.HOME.route) {
            Home(navController = navController)
        }
        composable(route = Screen.ABOUT.route) {
            About()
        }
        composable(route = Screen.MORE.route) {
            More()
        }
        composable(
            route = "details/{name}/{imageId}",
            arguments = listOf(navArgument("imageId") {
                type = NavType.IntType
            })
        ) {
            val name = it.arguments?.getString("name")
            val imageId = it.arguments?.getInt("imageId")
            Details(name = name ?: "", imageId = imageId ?: 0)
        }
    }
    }
}