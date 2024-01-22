package com.classes.smashcompetitors.victoryactivity

import android.content.Intent
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.classes.smashcompetitors.banned
import com.classes.smashcompetitors.chosen
import com.classes.smashcompetitors.mainactivity.MainActivity
import com.classes.smashcompetitors.scores
import com.classes.smashcompetitors.step

class ReturnListener(private val activity: AppCompatActivity) : OnClickListener {
    override fun onClick(v: View?) {
        scores.clearScore()
        chosen.clear()
        banned.clear()
        step = 1

        val intent = Intent(activity.baseContext, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}