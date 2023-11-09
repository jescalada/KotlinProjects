package com.example.lecture9.ui.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture9.R

@Composable
fun Home() {
    val list = listOf(
        Character("Ahsoka", R.drawable.ahsoka),
        Character("BB8", R.drawable.bb8),
        Character("C3PO", R.drawable.c3po),
        Character("Chewbacca", R.drawable.chewbacca),
        Character("Grogu", R.drawable.grogu),
        Character("Jabba", R.drawable.jabba),
        Character("Kilo", R.drawable.kilo),
        Character("Trooper", R.drawable.trooper),
        Character("Yoda", R.drawable.yoda)
    )

    val stateList = remember {
        list.toMutableStateList()
    }

    LazyColumn(content = {
        items(stateList.size) { index ->
            CharacterItem(stateList[index], clickHandler = {
                stateList.removeAt(index)
            })
        }
    })
}

@Composable
fun CharacterItem(character: Character, clickHandler: () -> Unit = {}) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(0xFF009688))
    ) {
        Text(
            character.name,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(12.dp)
        )
        IconButton(
            onClick = { clickHandler() },
            modifier = Modifier.padding(12.dp)
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Close",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}