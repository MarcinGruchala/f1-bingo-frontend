package com.frontend.f1bingo.views.loginactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frontend.f1bingo.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(applicationContext)
        auth =  Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        isUserCurrentlySignedIn()
    }

    private fun isUserCurrentlySignedIn() {
        auth.currentUser?.let {
            //TODO
        }
    }
}