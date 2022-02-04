package com.nila.testshot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nila.testshot.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val loginFragment = LoginFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, loginFragment).commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}