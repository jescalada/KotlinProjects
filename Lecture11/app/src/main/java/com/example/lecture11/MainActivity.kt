package com.example.lecture11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.lecture11.ui.main.ArtState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val artRepository = (application as MyApp).artRepository
        setContent {
            val artState = ArtState(artRepository)
            LaunchedEffect(artState) {
                artState.getArtwork()
            }
            MainContent(artState)
        }
    }
}

@Composable
fun MainContent(artState: ArtState) {
    LazyColumn(content = {
        items(artState.artwork.value.size) { index ->
            Text(text = artState.artwork.value[index].title)
        }
    })
}