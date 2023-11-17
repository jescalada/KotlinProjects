package com.example.lab8juanescalada.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController, currentColorHex: MutableLongState) {
    val colors = listOf(
        0xFFF44336,
        0xFFE91E63,
        0xFF9C27B0,
        0xFF3F51B5,
        0xFF2196F3,
        0xFF009688,
        0xFF4CAF50,
        0xFFFFEB3B
    )

    val stateList = remember {
        colors.toMutableStateList()
    }

    LazyColumn(content = {
        items(stateList.size) { index ->
            ColorCard(stateList[index], navController = navController, currentColorHex = currentColorHex)
        }
    })
}

@Composable
fun ColorCard(colorHex: Long, navController: NavController, currentColorHex: MutableLongState) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxSize()
            .clickable { cardClickHandler(colorHex, currentColorHex) }
            .padding(12.dp)
            .background(Color(colorHex))
            .padding(12.dp)
    ) {
        IconButton(
            // Juan Escalada A01285535
            onClick = { infoClickHandler(navController, colorHex) },
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            // Align the icon to the top right corner
            Icon(
                Icons.Rounded.Info,
                contentDescription = "Close",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

fun cardClickHandler(colorHex: Long, currentColorHex: MutableLongState) {
    // Change the colour of the star using the mutable state
    currentColorHex.longValue = colorHex
}

fun infoClickHandler(navController: NavController, colorHex: Long) {
    // Navigate to the info screen
    navController.navigate("info/$colorHex")
}