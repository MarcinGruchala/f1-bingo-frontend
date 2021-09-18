package com.frontend.f1bingo.views.mainactivity.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.frontend.f1bingo.databinding.FragmentProfileBinding
import com.frontend.f1bingo.views.loginactivity.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private const val TAG = "MAPF"
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        auth = Firebase.auth
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUserData()
        setOnClickListeners()
    }

    private fun bindUserData() {
        auth.currentUser?.let {
            binding.tvUserEmail.text = "User email: ${it.email}"
        }
    }

    private fun setOnClickListeners() {
        binding.apply {
            btnSignOut.setOnClickListener {
                Log.d(TAG,"Sign out")
                auth.signOut()
                startLoginActivity()
            }
        }
    }

    private fun startLoginActivity() {
        val intent = Intent(activity, LoginActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }
}