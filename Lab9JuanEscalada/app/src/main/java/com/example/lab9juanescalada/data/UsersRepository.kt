package com.example.lab9juanescalada.data

class UsersRepository(private val userDao: UserDao) {
    fun getAllUsers(): List<LocalUser> {
        return userDao.getAllUsers()
    }

    fun getUser(id: Int): LocalUser {
        return userDao.getUser(id)
    }

    fun insertUser(user: LocalUser) {
        userDao.insertUser(user.name, user.email)
    }
}