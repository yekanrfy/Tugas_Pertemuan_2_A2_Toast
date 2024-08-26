package com.example.tugaspertemuan2a2toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan2a2toast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi di dalam onCreate
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Penggunaan binding
        binding.buttonLogin.setOnClickListener {
            // Mendapatkan username dan password
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Menampilkan Toast dengan logo Android
                showCustomToast(username, password)
            } else {
                Toast.makeText(this, "Please enter Username and Password", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showCustomToast(username: String, password: String) {
        // Membuat layout inflater untuk custom toast
        val inflater: LayoutInflater = layoutInflater
        val layout = inflater.inflate(
            R.layout.custom_toast_layout, // Ini adalah layout custom toast
            findViewById(R.id.custom_toast_container)
        )

        // Mengatur image dan text dalam custom toast
        val imageView: ImageView = layout.findViewById(R.id.image)
        imageView.setImageResource(android.R.drawable.sym_def_app_icon) // Ini adalah logo Android

        val textView: TextView = layout.findViewById(R.id.text)
        textView.text = "$username"

        // Membuat toast dan menampilkan custom layout
        with(Toast(applicationContext)) {
            duration = Toast.LENGTH_LONG
            view = layout
            // Mengatur toast muncul di bagian bawah
            setGravity(Gravity.BOTTOM, 0, 100)
            show()
        }
    }
}
