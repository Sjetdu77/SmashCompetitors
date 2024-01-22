package com.classes.smashcompetitors

import android.widget.ImageButton
import com.example.smashcompetitors.R

var bestOfFirstToSel = 0
var chosen = arrayListOf<ImageButton>()
var banned = arrayListOf<ImageButton>()
var step = 1
var scores = Scores()

fun ban(button : ImageButton) {
    button.setBackgroundResource(R.drawable.button_grey)
    button.isClickable = false
    button.isFocusable = false
    banned.add(button)
}

class Scores(private var score1 : Int = 0, private var score2 : Int = 0, var bestOfNum : Int = 0) {
    fun getScore(player : Int) : Int {
        return when (player) {
            1 -> score1
            2 -> score2
            else -> -1
        }
    }

    fun getAllScores() : String {
        return "$score1 - $score2"
    }

    fun addScore(player : Int) : Int {
        when (player) {
            1 -> score1++
            2 -> score2++
        }
        if (score1 == bestOfNum) {
            return 1
        }
        if (score2 == bestOfNum) {
            return 2
        }
        return 0
    }

    fun clearScore() {
        score1 = 0
        score2 = 0
        bestOfNum = 0
    }
}