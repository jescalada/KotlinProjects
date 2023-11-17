package com.example.lab8juanescalada.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.sp

@Composable
fun Info(colorHex: Long?) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = androidx.compose.ui.graphics.Color(colorHex!!)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "#${java.lang.Long.toHexString(colorHex).toUpperCase()}", fontSize = 64.sp)
    }
}