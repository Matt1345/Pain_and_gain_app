package com.example.pain_and_gain_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.example.pain_and_gain_app.databinding.DetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: DetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val about = intent.getStringExtra("message")
        val name = intent.getStringExtra("name")
        val picture = intent.getStringExtra("picture")

        binding.name.text = name.toString()
        binding.about.text = about.toString()
        binding.cobraTeam.setImageResource(R.drawable.background)
        binding.profile.load(picture) {
            transformations(CircleCropTransformation())
        }

        binding.exitButton.setOnClickListener {
            finish()
        }
    }
}