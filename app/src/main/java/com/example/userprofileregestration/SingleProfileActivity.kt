package com.example.userprofileregestration

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.userprofileregestration.databinding.ActivitySingleProfileBinding
import com.example.userprofileregestration.entity.Profile

class SingleProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ProfileViewModel(application)

        val profileId = intent.getIntExtra("PROFILE_ID", -1)
        if (profileId != -1) {
            viewModel.getProfileById(profileId).observe(this) { profile ->
                profile?.let { displayProfile(it) }
            }
        } else {
            // Handle invalid profile id or show error message
        }

    }

    private fun displayProfile(profile: Profile) {
        binding.apply {
            nameTextView.text = profile.name
            emailTextView.text = profile.email
            dateOfBirthTextView.text = profile.dateOfBirth
            districtTextView.text = profile.district
            mobileTextView.text = profile.mobile
        }
    }
}