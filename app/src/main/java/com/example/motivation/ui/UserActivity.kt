package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.Key.name)

        if(name !== "") {
            startActivity( Intent(this, MainActivity::class.java))
            finish()
        }
    }
    private fun handleSave() {

        val name = binding.editName.text.toString()

        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.Key.name, name)
           startActivity( Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Você precisa de um nome", Toast.LENGTH_LONG).show()
        }
    }
}