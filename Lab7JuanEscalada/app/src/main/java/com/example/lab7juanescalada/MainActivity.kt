package com.example.lab7juanescalada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7juanescalada.ui.theme.Lab7JuanEscaladaTheme
import java.lang.Math.ceil

data class Character(val name: String, val imageId: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContainer()
        }
    }
}

@Composable
fun MainContainer() {
    val characters = remember {
        mutableStateListOf<Character>(
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
    }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            onClick = {
                characters.shuffle()
            },
            modifier = Modifier.background(color = Color(0xFF7C46DD)).align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = "Shuffle", fontSize = 32.sp, color = Color.White)
        }

        for (i in 0 until kotlin.math.ceil(characters.size / 3.0).toInt()) {
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                for (j in 0..2) {
                    if (i * 3 + j < characters.size) {
                        CharacterItem(characters[i * 3 + j])
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val size = if (isExpanded) 400.dp else 200.dp

    Card(
        modifier = Modifier
            .padding(12.dp)
            .size(size)
            .animateContentSize()
            .clickable {
                // Expand the image on click
                isExpanded = !isExpanded
            }) {
        Column(
        ) {
            if (!isExpanded) {
                Text(
                    text = character.name,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }
            Image(
                painter = painterResource(id = character.imageId),
                contentDescription = "Yoda",
                modifier = Modifier
                    .height(size)
                    .width(size)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }

}
