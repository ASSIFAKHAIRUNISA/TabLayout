package com.example.tugasmycourse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tugasmycourse.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {

    private lateinit var inputUsername: TextInputEditText
    private lateinit var inputPassword: TextInputEditText
    private lateinit var btnRegister: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        inputUsername = view.findViewById<TextInputLayout>(R.id.username).editText as TextInputEditText // Ambil username
        inputPassword = view.findViewById<TextInputLayout>(R.id.password).editText as TextInputEditText
        btnRegister = view.findViewById(R.id.btn_register_button)

        btnRegister.setOnClickListener {
            performRegistration()
        }

        return view
    }

    private fun performRegistration() {
        val username = inputUsername.text.toString()
        val password = inputPassword.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            // Tampilkan pesan kesalahan
            return
        }

        // Arahkan ke HomeActivity dengan username
        navigateToHome(username)
    }

    private fun navigateToHome(username: String) {
        val intent = Intent(requireActivity(), HomeActivity::class.java)
        intent.putExtra("USERNAME", username) // Kirim username ke HomeActivity
        startActivity(intent)
        requireActivity().finish() // Tutup RegistrationActivity jika diperlukan
    }
}
