package com.frontend.f1bingo.views.loginactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frontend.f1bingo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}