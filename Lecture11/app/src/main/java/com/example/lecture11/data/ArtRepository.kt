package com.example.lecture11.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArtRepository(private val client: HttpClient) {
    suspend fun getArtwork(): Art? {
        val response = client.get(ApiEndpoints.FIELDS1.url)
        val json = response.body<JsonObject>().toString()
        return deserializeJson(json)
    }

    private fun deserializeJson(json: String): Art? {
        return Gson().fromJson(json, Art::class.java)
    }
}