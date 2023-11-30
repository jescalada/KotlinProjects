package com.example.pokeinfo.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PokemonRepository(private val client: HttpClient) {
    suspend fun getPokemonData(id: Int): Pokemon? {
        val response = client.get("${ApiEndpoints.POKEMON.url}/$id")
        val json = response.body<JsonObject>().toString()
        println(json)
        return deserializeJson(json)
    }

    private fun deserializeJson(json: String): Pokemon? {
        return Gson().fromJson(json, Pokemon::class.java)
    }
}