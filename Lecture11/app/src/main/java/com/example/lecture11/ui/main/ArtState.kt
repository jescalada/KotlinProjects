package com.example.lecture11.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.lecture11.data.ArtPiece
import com.example.lecture11.data.ArtRepository

class ArtState(private val artRepository: ArtRepository) {
    var artwork: MutableState<List<ArtPiece>> = mutableStateOf(emptyList())

    suspend fun getArtwork() {
        artwork.value = artRepository.getArtwork()?.pieces ?: emptyList()
    }
}