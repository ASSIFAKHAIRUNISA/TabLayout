package com.example.tugasmycourse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmycourse.R

class HomeActivity : AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private lateinit var logoutButton: ImageView // Menambahkan variabel untuk tombol logout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // Pastikan ini adalah layout yang benar

        usernameTextView = findViewById(R.id.welcome_user)
        logoutButton = findViewById(R.id.img_2) // Menginisialisasi tombol logout

        // Ambil username dari Intent
        val username = intent.getStringExtra("USERNAME") ?: "No Username"
        usernameTextView.text = "Welcome, $username"

        // Set OnClickListener untuk logout button
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK) // Clear stack
            startActivity(intent)
            finish() // Optional: Finish HomeActivity if you don't want to return to it
        }
    }
}
