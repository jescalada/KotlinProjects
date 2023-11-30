package com.example.pokeinfo.data

enum class ApiEndpoints(val url: String) {
    BASE_URL("https://pokeapi.co/api/v2"),
    POKEMON("${BASE_URL.url}/pokemon")
}