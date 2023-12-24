package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()
        handleUserName()

        binding.newPhraseButton.setOnClickListener(this)
        binding.imgAll.setOnClickListener(this)
        binding.imgSunny.setOnClickListener(this)
        binding.imgPeople.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.new_phrase_button) {
            Toast.makeText(this, "Progress", Toast.LENGTH_LONG).show()
        } else if (v.id in listOf(R.id.img_all, R.id.img_sunny, R.id.img_people)) {
            handleFilter(v.id)
        }
    }

    fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.Key.name)
        binding.userName.text = "Oi, ${name}"
    }

    fun handleFilter(id: Int) {

        if (id == R.id.img_all) {
            binding.imgAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        } else if (id == R.id.img_sunny) {
            binding.imgSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
        } else if (id == R.id.img_people) {
            binding.imgPeople.setColorFilter(ContextCompat.getColor(this, R.color.white))
        }
    }
}
