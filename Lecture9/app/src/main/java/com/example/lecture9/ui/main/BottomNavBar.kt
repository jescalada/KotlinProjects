package com.example.lecture9.ui.main

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val navItems = listOf(
        NavItem(
            navRoute=Screen.HOME.route,
            icon=Icons.Rounded.Home,
            title="Home"
        ),
        NavItem(
            navRoute=Screen.MORE.route,
            icon=Icons.Rounded.List,
            title="More"
        ),
        NavItem(
            navRoute=Screen.ABOUT.route,
            icon=Icons.Rounded.Info,
            title="About"
        )
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {
            NavigationBarItem(
                selected= false,
                onClick = {
                    navController.navigate(it.navRoute)
                },
                icon = {
                    Icon(
                        it.icon,
                        contentDescription = null,
                        modifier = androidx.compose.ui.Modifier.size(30.dp),

                    )
                },
            )
        }
    }
}