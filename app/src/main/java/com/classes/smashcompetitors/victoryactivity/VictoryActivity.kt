package com.classes.smashcompetitors.victoryactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.smashcompetitors.R

class VictoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        val victorious : TextView = findViewById(R.id.victorious)
        val whoWins = intent.extras!!.getInt("Victorious")

        victorious.text = if (whoWins == 1) {
            "Player 1"
        } else {
            "Player 2"
        }

        val restartButton : Button = findViewById(R.id.restart)
        restartButton.setOnClickListener(ReturnListener(this))
    }
}