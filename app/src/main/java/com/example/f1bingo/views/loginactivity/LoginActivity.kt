package com.example.f1bingo.views.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.f1bingo.databinding.ActivityLoginBinding
import com.example.f1bingo.views.mainactivity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}