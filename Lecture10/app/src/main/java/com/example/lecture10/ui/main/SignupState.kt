package com.example.lecture10.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignupState {
    var name by mutableStateOf("")
    val onNameChange: (String) -> Unit = { name = it }
    var email by mutableStateOf("")
    val onEmailChange: (String) -> Unit = {
        email = it
        // Check if email is valid using a simple regex
        validEmail = it.matches(Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+"))
    }
    var validEmail by mutableStateOf(false)
}