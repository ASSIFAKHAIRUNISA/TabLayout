package com.example.tugasmycourse

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.tugasmycourse.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var pagerAdapter: SelectionPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi ViewPager dan TabLayout
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        // Inisialisasi Adapter untuk ViewPager
        pagerAdapter = SelectionPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        // Menghubungkan TabLayout dengan ViewPager menggunakan TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Login"  // Nama tab untuk Fragment Login
                1 -> "Register"  // Nama tab untuk Fragment Register
                else -> ""
            }
        }.attach()
    }
}
