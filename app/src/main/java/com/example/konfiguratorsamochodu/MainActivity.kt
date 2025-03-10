package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageCar: ImageView = findViewById(R.id.imageCar)
        val sedan: RadioButton = findViewById(R.id.Sedan)
        val suv: RadioButton = findViewById(R.id.SUV)
        val hatchback: RadioButton = findViewById(R.id.Hatchback)

        sedan.setOnClickListener{
            imageCar.setImageResource(R.drawable.sedan)
        }
        suv.setOnClickListener{
            imageCar.setImageResource(R.drawable.suv)
        }
        hatchback.setOnClickListener{
            imageCar.setImageResource(R.drawable.hatchback)
        }

    }
}