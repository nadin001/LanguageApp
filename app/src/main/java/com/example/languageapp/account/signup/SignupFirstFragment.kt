package com.example.languageapp.account.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.languageapp.databinding.FragmentSignup1Binding
import com.example.languageapp.databinding.FragmentSignup1Binding.inflate


class SignupFirstFragment : Fragment() {
    private lateinit var binding: FragmentSignup1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, container, false)
        return binding.root
    }
    fun getFirstName(): String = binding.inputFirstNameEditText.text.toString()

    fun getSecondName(): String = binding.inputSecondNameEditText.text.toString()

    fun getEmail(): String = binding.inputEmailEditText.text.toString()
}