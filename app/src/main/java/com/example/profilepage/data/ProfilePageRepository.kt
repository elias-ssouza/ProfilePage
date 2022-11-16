package com.example.profilepage.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProfilePageRepository(private val dao: ProfilePageDao) {

    fun insert(profilePage: ProfilePage) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(profilePage)
        }
    }

    fun getAll() = dao.getAll()
}