package com.valladolid.jhon.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio01 : AppCompatActivity() {
    private lateinit var greenView: View
    private lateinit var buttonShow: Button
    private lateinit var buttonHide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)
        greenView = findViewById(R.id.green_view)
        buttonShow = findViewById(R.id.button_show)
        buttonHide = findViewById(R.id.button_hide)

        buttonShow.setOnClickListener {
            greenView.visibility = View.VISIBLE
        }

        buttonHide.setOnClickListener {
            greenView.visibility = View.GONE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
