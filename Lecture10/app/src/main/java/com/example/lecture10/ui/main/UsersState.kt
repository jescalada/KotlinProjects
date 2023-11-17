package com.example.lecture10.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.lecture10.data.LocalUser
import com.example.lecture10.data.UsersRepository

class UsersState(private val usersRepository: UsersRepository) {
    var users by mutableStateOf(usersRepository.getAllUsers())

    fun refresh() {
        users = usersRepository.getAllUsers()
    }
    fun addUser(user: LocalUser) {
        usersRepository.insertUser(user)
        users = usersRepository.getAllUsers()
    }
}