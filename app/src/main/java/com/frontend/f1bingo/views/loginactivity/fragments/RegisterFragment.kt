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
import com.frontend.f1bingo.views.loginactivity.utils.RegistrationInputHandler
import com.frontend.f1bingo.views.loginactivity.utils.RegistrationInputStatus
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
                navigateToLoginFragment(view)
            }
        }
    }

    private fun setRegistrationClickListener() {
        resetErrorMessage()
        val email = binding.etRegisterEmail.text.trim().toString()
        val password = binding.etRegisterPassowrd.text.trim().toString()
        val repeatPassword = binding.etConfirmPassword.text.trim().toString()

        when(RegistrationInputHandler.validateRegistrationInput(email, password, repeatPassword)) {
            RegistrationInputStatus.OK -> {
                registerWithEmailAndPassword(email, password)
            }
            RegistrationInputStatus.EMPTY -> {
                Toast.makeText(
                    activity,
                    getString(R.string.registration_empty_fields),
                    Toast.LENGTH_LONG
                ).show()
                binding.tvRegisterErrorMessage.text = getString(R.string.registration_empty_fields)
            }
            RegistrationInputStatus.INVALID_PASSWORD -> {
                Toast.makeText(
                    activity,
                    getString(R.string.registration_invalid_password),
                    Toast.LENGTH_LONG
                ).show()
                binding.tvRegisterErrorMessage.text = getString(R.string.registration_invalid_password)
            }
            else -> {}
        }
    }

    private fun registerWithEmailAndPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                authResult?.let {
                    Toast.makeText(
                        activity,
                        getString(R.string.registration_succeed),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            .addOnFailureListener { e ->
                Log.d(TAG, e.message.toString())
                Toast.makeText(activity, e.message.toString(), Toast.LENGTH_LONG).show()
                binding.tvRegisterErrorMessage.text =  e.message.toString()
            }
    }

    private fun resetErrorMessage() {
        binding.tvRegisterErrorMessage.text = ""
    }

    private fun navigateToLoginFragment(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
    }
}