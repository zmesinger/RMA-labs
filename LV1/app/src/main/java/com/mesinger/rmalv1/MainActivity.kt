package com.mesinger.rmalv1

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lukaImage = findViewById<ImageView>(R.id.lukaImage)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val description = findViewById<TextView>(R.id.description)
        val nameSurname = findViewById<TextView>(R.id.nameSurname)
        val nameSurnameEditText = findViewById<EditText>(R.id.nameSurnameEditText)
        val descriptionEditText = findViewById<EditText>(R.id.descriptionEditText)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)

        submitButton.setOnClickListener {

            nameSurname.text = nameSurnameEditText.text
            description.text = descriptionEditText.text

            Log.d("MainActivity", "submitButton")
        }

        calculateButton.setOnClickListener {
            var bmi = calculateBMI(heightEditText.text.toString().toDouble(), weightEditText.text.toString().toDouble()).toString()

            Toast.makeText(this, bmi, Toast.LENGTH_SHORT).show()

            Log.d("MainActivity", "calculateButton")
        }

        Log.d("MainActivity", "onCreate")
    }

    private fun calculateBMI(height: Double, weight: Double): Double{
        var heightInMeters: Double = height/100;
        Log.d("MainActivity", "calculateBMI")
        return weight/(heightInMeters*heightInMeters)

    }
}