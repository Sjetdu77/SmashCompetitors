package com.classes.smashcompetitors.randomactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.smashcompetitors.R

class RandomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        val randomButton : Button = findViewById(R.id.random_button)
        randomButton.setOnClickListener(RandomButtonListener(this))
    }
}