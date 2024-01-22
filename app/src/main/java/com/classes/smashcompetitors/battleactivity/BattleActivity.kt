package com.classes.smashcompetitors.battleactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.classes.smashcompetitors.scores
import com.example.smashcompetitors.R

class BattleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle)

        val mapChosen : ImageView = findViewById(R.id.map_chosen)
        val matches : TextView = findViewById(R.id.matches)
        val score1View : TextView = findViewById(R.id.score1)
        val score2View : TextView = findViewById(R.id.score2)
        val victoryP1 : Button = findViewById(R.id.victory_p1)
        val victoryP2 : Button = findViewById(R.id.victory_p2)

        mapChosen.setBackgroundResource(
            when (intent.extras!!.getString("map")) {
                "Battlefield" -> {
                    R.drawable.battlefield
                }
                "Small Battlefield" -> {
                    R.drawable.small_battlefield
                }
                "Kalos Pokémon League" -> {
                    R.drawable.kalos_pokemon_league
                }
                "Lylat Cruise" -> {
                    R.drawable.lylat_cruise
                }
                "Northern Cave" -> {
                    R.drawable.northern_cave
                }
                "Pokémon Stadium 2" -> {
                    R.drawable.pokemon_stadium_2
                }
                "Smashville" -> {
                    R.drawable.smashville
                }
                "Town & City" -> {
                    R.drawable.town_city
                }
                "Yoshi's Story" -> {
                    R.drawable.yoshis_story
                }
                "Hollow Bastion" -> {
                    R.drawable.hollow_bastion
                }
                else -> {
                    R.drawable.final_destination
                }
            }
        )

        matches.text = scores.bestOfNum.toString()
        score1View.text = scores.getScore(1).toString()
        score2View.text = scores.getScore(2).toString()

        victoryP1.setOnClickListener(VictoryListener(this, 1))
        victoryP2.setOnClickListener(VictoryListener(this, 2))
    }
}