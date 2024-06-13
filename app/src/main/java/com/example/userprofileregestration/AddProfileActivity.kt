package com.example.userprofileregestration

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.userprofileregestration.databinding.ActivityAddProfileBinding
import com.example.userprofileregestration.entity.Profile

class AddProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ProfileViewModel(application)

        binding.saveButton.setOnClickListener {
            saveProfile()
        }

    }

    private fun saveProfile() {
        val name = binding.nameEditText.text.toString().trim()
        val email = binding.emailEditText.text.toString().trim()
        val dateOfBirth = binding.dateOfBirthEditText.text.toString().trim()
        val district = binding.districtEditText.text.toString().trim()
        val mobile = binding.mobileEditText.text.toString().trim()

        if (name.isNotEmpty() && email.isNotEmpty() && dateOfBirth.isNotEmpty() && district.isNotEmpty() && mobile.isNotEmpty()) {
            val profile = Profile(name = name, email = email, dateOfBirth = dateOfBirth, district = district, mobile = mobile)
            viewModel.insert(profile)
            finish()
        } else {
            // Handle empty fields or show error message
        }
    }
}