package com.example.profilepage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.profilepage.data.ProfilePage
import com.example.profilepage.data.ProfilePageRepository

class MainViewModel(private val profilePageRepository: ProfilePageRepository): ViewModel() {

    fun insert(profilePage: ProfilePage) {
        profilePageRepository.insert(profilePage)
    }

    fun getAll(): LiveData<List<ProfilePage>> {
        return profilePageRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: ProfilePageRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}