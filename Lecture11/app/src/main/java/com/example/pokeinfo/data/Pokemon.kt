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
    val types: List<Type>
)

data class Type(
    val type: Map<String, String>
)
