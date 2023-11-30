package com.example.pokeinfo

import android.app.Application
import com.example.pokeinfo.data.PokemonRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MyApp : Application() {
    val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }

    val pokemonRepository by lazy { PokemonRepository(client) }
}