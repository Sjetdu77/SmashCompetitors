package com.classes.smashcompetitors.randomactivity

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.classes.smashcompetitors.counterpickactivity.CounterpickActivity
import kotlin.random.Random

class RandomButtonListener(private val activity: AppCompatActivity) : View.OnClickListener {
    override fun onClick(v: View?) {
        val p1 = Random.nextBoolean()

        val context = v!!.context
        val intent = Intent(context, CounterpickActivity::class.java)
        intent.putExtra("Matches", activity.intent.extras?.getInt("Matches"))
        intent.putExtra("Player 1", p1)
        context.startActivity(intent)
        activity.finish()
    }
}