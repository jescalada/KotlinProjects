package com.example.lecture11.data

enum class ApiEndpoints(val url: String) {
    BASE_URL("https://api.artic.edu/api/v1/"),
    ARTWORKS("${BASE_URL}/artworks"),
    FIELDS1("${ARTWORKS.url}?fields=id,title,image_id")
}