package com.example.profilepage

import android.app.Application
import com.example.profilepage.data.AppDatabase
import com.example.profilepage.data.ProfilePageRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { ProfilePageRepository(database.profileDao()) }
}