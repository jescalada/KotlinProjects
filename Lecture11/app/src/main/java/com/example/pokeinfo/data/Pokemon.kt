package com.example.pokeinfo.data

import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("data")
    val pokemonList: List<Pokemon>
)

data class Pokemon(
    val id: String,
    val name: String,
    val sprites: Map<String, Any>,
    val types: List<Type>,
    val stats: List<Stat>
)

data class Type(
    val type: Map<String, String>
)

data class Stat(
    val stat: Map<String, String>,
    val base_stat: Int
)