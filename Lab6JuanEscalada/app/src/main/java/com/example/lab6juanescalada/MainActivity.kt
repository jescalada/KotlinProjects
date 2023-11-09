package com.example.lab6juanescalada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lab6juanescalada.ui.theme.Lab6JuanEscaladaTheme

/**
 * Juan Escalada, A01285535
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6JuanEscaladaTheme {
                // Expand the surface to fill the screen
                Surface(
                    color = Color(127, 142, 173, 255),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column {
                        FirstRow()
                        SecondRow()
                        ThirdRow()
                    }
                }
            }
        }
    }
}

@Composable
fun FirstRow() {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(top = 75.dp)
    ) {
        Box(modifier= Modifier
            .background(Color.Blue)
            .size(200.dp))
        Box(modifier= Modifier
            .background(Color.Red)
            .size(60.dp))
    }
}

@Composable
fun SecondRow() {
    Row(
        modifier = Modifier
            .padding(top = 75.dp)
            .background(Color(130, 79, 211, 255))
            .padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        Box(modifier= Modifier
            .background(Color(255, 180, 180))
            .size(100.dp))
        Box(modifier= Modifier
            .background(Color.Green)
            .size(80.dp))
        Box(modifier= Modifier
            .background(Color.Yellow)
            .size(120.dp))
    }
}

@Composable
fun ThirdRow() {
    Row(
        modifier= Modifier
            .padding(top = 75.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(modifier= Modifier
            .background(Color(104, 78, 38, 255))
            .size(150.dp)) {
            Text(
                text = "Lab 6",
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
        }
    }
}