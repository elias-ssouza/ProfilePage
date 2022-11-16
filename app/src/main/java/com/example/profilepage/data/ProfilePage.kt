package com.example.profilepage.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProfilePage(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val subtitle: String,
    val text: String,
)