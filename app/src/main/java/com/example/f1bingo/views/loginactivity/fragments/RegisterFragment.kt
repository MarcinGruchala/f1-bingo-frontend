package com.example.f1bingo.views.loginactivity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.f1bingo.R
import com.example.f1bingo.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnCancelRegister.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }

}