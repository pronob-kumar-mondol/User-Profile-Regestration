package com.example.userprofileregestration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileregestration.entity.Profile
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application):AndroidViewModel(application) {
    private val repository = ProfileRepository(application)
    val profiles: LiveData<List<Profile>> = repository.getAllProfiles()

    fun insert(profile: Profile) {
        viewModelScope.launch {
            repository.insert(profile)
        }
    }

    fun update(profile: Profile) {
        viewModelScope.launch {
            repository.update(profile)
        }
    }

    fun delete(profile: Profile) {
        viewModelScope.launch {
            repository.delete(profile)
        }
    }

    fun getProfileById(id: Int): LiveData<Profile?> = liveData {
        emit(repository.getProfileById(id))
    }
}