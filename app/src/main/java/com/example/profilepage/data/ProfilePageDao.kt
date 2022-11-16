package com.example.profilepage.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProfilePageDao {

    @Query("SELECT * FROM ProfilePage")
    fun getAll(): LiveData<List<ProfilePage>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profilePage: ProfilePage)

}