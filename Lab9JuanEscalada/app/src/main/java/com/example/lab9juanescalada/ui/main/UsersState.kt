package com.example.lab9juanescalada.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import com.example.lab9juanescalada.data.LocalUser
import com.example.lab9juanescalada.data.UsersRepository

class UsersState(private val usersRepository: UsersRepository) {
    var users = usersRepository.getAllUsers().toMutableStateList()

    fun refresh() {
        users.clear()
        users.addAll(usersRepository.getAllUsers())
    }
    fun addUser(user: LocalUser) {
        users.add(user)
        usersRepository.insertUser(user)
    }
    fun deleteUser(id: Int) {
        users.remove(users.find { it.uid == id })
        usersRepository.deleteUser(id)
    }
}