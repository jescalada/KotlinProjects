package com.example.lecture11.data

import com.google.gson.annotations.SerializedName

data class Art(
    @SerializedName("data")
    val pieces: List<ArtPiece>
)

data class ArtPiece(
    val id: String,
    val title: String,
    val image: String
)