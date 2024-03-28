package com.example.languageapp.account.signup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignupAdapter(fragmentActivity: FragmentActivity, private val list: List<Fragment>) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int = list.size
    override fun createFragment(position: Int): Fragment = list[position]
    fun getFragmentByPosition(position: Int) : Fragment = list[position]
}