package com.example.pokeinfo.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.pokeinfo.data.Pokemon
import com.example.pokeinfo.data.PokemonRepository
import kotlin.random.Random

class PokemonState(private val pokemonRepository: PokemonRepository) {
    var randomPokemonList: MutableState<List<Pokemon>> = mutableStateOf(emptyList())

    suspend fun getPokemon(id: Int): Pokemon {
        val parsedPokemon = parsePokemon(pokemonRepository.getPokemonData(id))
        return parsedPokemon ?: Pokemon("0", "Error", emptyMap(), emptyList(), emptyList())
    }

    fun addPokemonToList(pokemon: Pokemon) {
        randomPokemonList.value = randomPokemonList.value + pokemon
    }

    private fun parsePokemon(pokemon: Pokemon?): Pokemon? {
        if (pokemon == null) {
            return null
        }
        val pokemonName = pokemon.name.capitalize()
//        val pokemonTypes = pokemon.types.map { Type(name = it.name.capitalize()) }
//        val pokemonStats = pokemon.stats.map { Stat(name = it.name.capitalize(), value = it.value) }
        val pokemonId = pokemon.id.padStart(3, '0')
        return Pokemon(pokemonId, pokemonName, pokemon.sprites, pokemon.types, pokemon.stats)
    }

    suspend fun loadRandomPokemon() {
        for (i in 1..9) {
            val id = Random.nextInt(1, 1017)
            addPokemonToList(getPokemon(id))
        }
    }
}