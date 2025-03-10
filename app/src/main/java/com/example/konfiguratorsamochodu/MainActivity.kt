package com.example.konfiguratorsamochodu

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
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

        val wyswietl: TextView = findViewById(R.id.podsumowanie)
        val button = findViewById<Button>(R.id.submit)
        val klimatyzacja = findViewById<CheckBox>(R.id.klimatyzacja)
        val skora = findViewById<CheckBox>(R.id.skora)

        button.setOnClickListener {
            val wybranySamochod: String = when {
                sedan.isChecked -> "sedan"
                suv.isChecked -> "suv"
                hatchback.isChecked -> "hatchback"
                else -> "Brak wyboru!"
            }
            val dodatki = mutableListOf<String>()
            if (klimatyzacja.isChecked) dodatki.add("klimatyzacja")
            if (skora.isChecked) dodatki.add("skórzane fotele")
            val tekstDodatki = if (dodatki.isEmpty()) "brak dodatków" else dodatki.joinToString(", ")
            wyswietl.text = ("Zamówiono samochód typu: $wybranySamochod, dodatki: $tekstDodatki")

        }
    }
}