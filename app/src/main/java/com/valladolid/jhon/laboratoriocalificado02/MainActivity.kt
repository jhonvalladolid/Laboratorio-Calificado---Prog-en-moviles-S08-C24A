package com.valladolid.jhon.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEjercicio01: Button = findViewById(R.id.btnEjercicio01)
        val btnEjercicio02: Button = findViewById(R.id.btnEjercicio02)

        btnEjercicio01.setOnClickListener {
            val intent = Intent(this, Ejercicio01::class.java)
            startActivity(intent)
        }

        btnEjercicio02.setOnClickListener {
            val intent = Intent(this, Ejercicio02::class.java)
            startActivity(intent)
        }
    }
}
