package com.example.pokeinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokeinfo.data.Pokemon
import com.example.pokeinfo.ui.main.PokemonState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pokemonRepository = (application as MyApp).pokemonRepository
        setContent {
            val pokemonState = PokemonState(pokemonRepository)
            LaunchedEffect(pokemonState) {
                pokemonState.loadRandomPokemon()
            }
            MainContent(pokemonState)
        }
    }
}

@Composable
fun MainContent(pokemonState: PokemonState) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(pokemonState.randomPokemonList.value.size) { index ->
                val pokemon = pokemonState.randomPokemonList.value[index]
                PokemonCard(pokemon)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(pokemon: Pokemon) {
    var isFlipped by remember {
        mutableStateOf(false)
    }

    Surface(onClick = {isFlipped = !isFlipped}, modifier = Modifier.animateContentSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp, 4.dp)
                .border(BorderStroke(4.dp, Color(0xFFFF0000)))
                .background(color = Color(0xFFFFDADA), RoundedCornerShape(16.dp))
                .padding(8.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            if (!isFlipped) {
                CardFront(pokemon)
            } else {
                CardBack(pokemon)
            }
        }
    }
}

@Composable
fun CardFront(pokemon: Pokemon) {
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center
    )
    // Render the image using the URL from the Pokemon object
    AsyncImage(
        model = parseImageUrl(pokemon.sprites),
        contentDescription = pokemon.name
    )
    Text(
        text = "Types: ${pokemon.types.joinToString(", ") { it.type["name"]?.uppercase()!! }}",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun CardBack(pokemon: Pokemon) {
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.headlineMedium
    )
    Text(text = "Stats", style = MaterialTheme.typography.headlineSmall)
    Text(
        text = pokemon.stats.joinToString("\n") { "${it.stat["name"]?.uppercase()!!} = ${it.base_stat}" },
        style = MaterialTheme.typography.bodyMedium
    )
}

fun parseImageUrl(dict: Map<String, Any>): String {
    val other = dict["other"] as Map<String, Any>
    val officialArtwork = other["official-artwork"] as Map<String, Any>
    return officialArtwork["front_default"] as String
}