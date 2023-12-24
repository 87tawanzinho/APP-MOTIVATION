package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
    }

    override fun onClick(v: View) {
        if (v.id == R.id.new_phrase_button) {
            Toast.makeText(this, "Progress", Toast.LENGTH_LONG).show()
        }
    }

    fun handleUserName() {
        val name = SecurityPreferences(this).getString("name")
        binding.userName.text = "Oi, ${name}"
    }
}
