package com.classes.smashcompetitors.battleactivity

import android.content.Intent
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.classes.smashcompetitors.counterpickactivity.CounterpickActivity
import com.classes.smashcompetitors.scores
import com.classes.smashcompetitors.victoryactivity.VictoryActivity

class VictoryListener(private val activity: AppCompatActivity, private val player: Int) : OnClickListener {
    override fun onClick(v: View?) {
        v as Button
        val victory = scores.addScore(player)
        val direction : Class<out AppCompatActivity> = if (victory == 0) {
            CounterpickActivity::class.java
        } else {
            VictoryActivity::class.java
        }
        val intent = Intent(activity.baseContext, direction)
        intent.putExtra("Victorious", player)
        activity.startActivity(intent)
        activity.finish()
    }
}