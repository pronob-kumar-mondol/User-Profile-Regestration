package com.example.userprofileregestration

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.userprofileregestration.entity.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileRepository(context: Context) {

    private val profileDao = AppDatabase.getDatabase(context).profileDao()

    fun getAllProfiles(): LiveData<List<Profile>> = profileDao.getAllProfiles()

    suspend fun insert(profile: Profile) {
        withContext(Dispatchers.IO) {
            profileDao.insert(profile)
        }
    }

    suspend fun update(profile: Profile) {
        withContext(Dispatchers.IO) {
            profileDao.update(profile)
        }
    }

    suspend fun delete(profile: Profile) {
        withContext(Dispatchers.IO) {
            profileDao.delete(profile)
        }
    }

    suspend fun getProfileById(id: Int): Profile? {
        return withContext(Dispatchers.IO) {
            profileDao.getProfileById(id)
        }
    }
}