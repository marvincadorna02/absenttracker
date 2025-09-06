package com.example.absenttracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvRegister = findViewById<TextView>(R.id.tvRegister)
        val etSchoolId = findViewById<EditText>(R.id.schooldID)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val schoolId = etSchoolId.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (schoolId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please type your School ID and Password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
