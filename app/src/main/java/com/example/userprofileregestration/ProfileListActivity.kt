package com.example.userprofileregestration

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userprofileregestration.databinding.ActivityProfileListBinding
import com.example.userprofileregestration.entity.Profile

class ProfileListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileListBinding
    private val viewModel: ProfileViewModel by viewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProfileAdapter { profile -> showProfile(profile) }
        binding.recyclerView.adapter = adapter

        viewModel.profiles.observe(this) { profiles ->
            profiles?.let { adapter.submitList(it) }
            binding.totalProfilesText.text = "Total Profiles: ${profiles.size}"
        }

        binding.addProfileButton.setOnClickListener {
            val intent = Intent(this, AddProfileActivity::class.java)
            startActivity(intent)
        }


    }

    private fun showProfile(profile: Profile) {
        val intent = Intent(this, SingleProfileActivity::class.java)
        intent.putExtra("PROFILE_ID", profile.id)
        startActivity(intent)
    }

}