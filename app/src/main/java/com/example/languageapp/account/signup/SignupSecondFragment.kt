package com.example.languageapp.account.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.languageapp.databinding.FragmentSignup2Binding
import com.example.languageapp.databinding.FragmentSignup2Binding.inflate


class SignupSecondFragment : Fragment() {
    private lateinit var binding: FragmentSignup2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, container, false)
        return binding.root
    }
    fun getPassword(): String = binding.inputPasswordEditText.text.toString()
    fun getConfirm(): String = binding.inputConfirmEditText.text.toString()
}