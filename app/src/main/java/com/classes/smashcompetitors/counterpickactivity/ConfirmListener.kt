package com.classes.smashcompetitors.counterpickactivity

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.classes.smashcompetitors.ban
import com.classes.smashcompetitors.battleactivity.BattleActivity
import com.classes.smashcompetitors.scores
import com.classes.smashcompetitors.chosen
import com.classes.smashcompetitors.step
import com.example.smashcompetitors.R

class ConfirmListener(private val activity: AppCompatActivity, private val opponent: Button, private val backOpponent: Int) :
    View.OnClickListener {
    private fun clear(b: Button) {
        chosen.clear()
        step++
        b.isClickable = false
        b.visibility = View.INVISIBLE
        opponent.isClickable = true
        opponent.visibility = View.VISIBLE
        activity.findViewById<ConstraintLayout>(R.id.background_app).setBackgroundResource(backOpponent)
    }

    override fun onClick(v: View?) {
        v as Button

        if (scores.getAllScores() == "0 - 0") {
            when (step) {
                1 -> {
                    for (stage in chosen) {
                        ban(stage)
                    }
                    clear(v)
                }
                2 -> {
                    for (stage in chosen) {
                        ban(stage)
                    }
                    clear(v)
                }
                3 -> {
                    val intent = Intent(activity.baseContext, BattleActivity::class.java)
                    intent.putExtra("map", chosen[0].contentDescription)
                    activity.startActivity(intent)
                    activity.finish()
                }
            }
        } else when (step) {
            1 -> {
                for (stage in chosen) {
                    ban(stage)
                }
                clear(v)
            }
            2 -> {
                val intent = Intent(activity.baseContext, BattleActivity::class.java)
                intent.putExtra("map", chosen[0].contentDescription)
                activity.startActivity(intent)
                activity.finish()
            }
        }
    }
}