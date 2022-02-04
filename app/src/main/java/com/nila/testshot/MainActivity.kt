package com.nila.testshot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nila.testshot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        }
    }
}