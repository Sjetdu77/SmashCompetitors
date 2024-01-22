package com.classes.smashcompetitors.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.smashcompetitors.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bestOfFirstTo : Spinner = findViewById(R.id.boft)
        val numBestOfFirstTo : EditText = findViewById(R.id.numBoft)
        val launch : Button = findViewById(R.id.launch)

        numBestOfFirstTo.setText("3")

        ArrayAdapter.createFromResource(this, R.array.boft, android.R.layout.simple_spinner_item)
            .also {
                bestOfFirstTo.adapter = it
                bestOfFirstTo.setSelection(0)
                bestOfFirstTo.onItemSelectedListener = BOFTListener()
                (bestOfFirstTo.onItemSelectedListener as BOFTListener).numBestOfFirstTo = numBestOfFirstTo
            }

        launch.setOnClickListener(LaunchListener(this, numBestOfFirstTo))
    }
}



