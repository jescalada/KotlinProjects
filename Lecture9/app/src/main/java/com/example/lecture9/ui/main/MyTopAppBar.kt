package com.example.lecture9.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController) {
    MediumTopAppBar(
        title = {
            Text(text = "Lecture 9: Star Wars")
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(Screen.HOME.route)
            }) {
                Icon(Icons.Rounded.Home, contentDescription = null)
            }
            IconButton(onClick = {
                navController.navigate(Screen.MORE.route)
            }) {
                Icon(Icons.Rounded.List, contentDescription = null)
            }
            IconButton(onClick = {
                navController.navigate(Screen.ABOUT.route)
            }) {
                Icon(Icons.Rounded.Info, contentDescription = null)
            }
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )

}