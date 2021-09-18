package com.frontend.f1bingo.views.loginactivity.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.frontend.f1bingo.R
import com.frontend.f1bingo.databinding.FragmentLoginBinding
import com.frontend.f1bingo.views.loginactivity.utils.LoginInputHandler
import com.frontend.f1bingo.views.loginactivity.utils.LoginInputStatus
import com.frontend.f1bingo.views.mainactivity.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private const val TAG = "LALF"
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        auth = Firebase.auth
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners(view)
    }

    private fun setOnClickListeners(view: View) {
        binding.apply {
            btnLogin.setOnClickListener {
               setLoginClickListener()
            }
            btnRegister.setOnClickListener {
                setRegistrationClickListener(view)
            }
        }
    }

    private fun setLoginClickListener() {
        val email = binding.etEmail.text.trim().toString()
        val password = binding.etPassword.text.trim().toString()
        if (LoginInputHandler.validateLoginInput(email,password) == LoginInputStatus.OK) {
            signInWithEmailAndPassword(email, password)
        } else {
            Toast.makeText(
                activity,
                getString(R.string.login_empty_fields),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                authResult?.let {
                    startApp()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(activity,e.message.toString(), Toast.LENGTH_LONG).show()
                Log.d(TAG, e.message.toString())
            }
    }

    private fun setRegistrationClickListener(view: View) {
        Navigation.findNavController(view)
            .navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun startApp() {
        val intent = Intent(activity, MainActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

}