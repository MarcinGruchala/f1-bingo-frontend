package com.frontend.f1bingo.views.loginactivity.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.frontend.f1bingo.R
import com.frontend.f1bingo.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private const val TAG = "LARF"
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        auth = Firebase.auth
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnRegisterRegister.setOnClickListener {
                setRegistrationClickListener()
            }
            btnCancelRegister.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }

    private fun setRegistrationClickListener() {
        val email = binding.etRegisterEmail.text.trim().toString()
        val password = binding.etRegisterPassowrd.text.trim().toString()
        val repeatPassword = binding.etConfirmPassword.text.trim().toString()

        if (password == repeatPassword) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { authResult ->
                    authResult?.let {
                        Toast.makeText(activity,"Registration succeed", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(activity,"Registration failed", Toast.LENGTH_LONG).show()
                    Log.d(TAG, e.message.toString())
                }
        }
    }
}