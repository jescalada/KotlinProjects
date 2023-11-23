package com.example.lecture11

import android.app.Application
import com.example.lecture11.data.ArtRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MyApp : Application() {
    val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }

    val artRepository by lazy { ArtRepository(client) }
}