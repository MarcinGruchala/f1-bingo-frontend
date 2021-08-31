package com.example.f1bingo.views.loginactivity.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.f1bingo.R
import com.example.f1bingo.databinding.FragmentLoginBinding
import com.example.f1bingo.views.mainactivity.MainActivity

private const val TAG = "LALF"
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnLogin.setOnClickListener {
                Intent(activity, MainActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnRegister.setOnClickListener {
                Log.d(TAG, "btnRegister clicked")
                Navigation.findNavController(view)
                    .navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

}