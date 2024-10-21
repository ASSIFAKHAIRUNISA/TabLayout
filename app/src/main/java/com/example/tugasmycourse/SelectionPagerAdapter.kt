package com.example.tugasmycourse

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SelectionPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2 // Jumlah fragment yang digunakan (Login dan Register)
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()  // Mengembalikan Fragment Login
            1 -> RegistrationFragment()  // Mengembalikan Fragment Register
            else -> throw IllegalStateException("Posisi Fragment tidak valid")
        }
    }
}