package com.example.lab8juanescalada.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableLongState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavController, currentColorHex: MutableLongState) {
    CenterAlignedTopAppBar(
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally,) {
                Text(text = "Colors", fontSize = 30.sp, modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally))
            }
                },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.HOME.route)
            }) {
                Icon(Icons.Rounded.Home, contentDescription = null)
            }
        },
        actions = {
            // Change the icon color to the current color
            Icon(
                Icons.Rounded.Star,
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .size(48.dp)
                    .padding(end = 8.dp, top = 8.dp),
                tint = androidx.compose.ui.graphics.Color(currentColorHex.longValue)
            )
        }, scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )

}