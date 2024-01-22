package com.classes.smashcompetitors.mainactivity

import android.content.Intent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.classes.smashcompetitors.bestOfFirstToSel
import com.classes.smashcompetitors.randomactivity.RandomActivity
import com.classes.smashcompetitors.scores

class LaunchListener(private val activity: AppCompatActivity, private val numBestOfFirstTo: EditText) : View.OnClickListener {
    override fun onClick(v: View?) {
        scores.bestOfNum = this.numBestOfFirstTo.text.toString().toInt()

        if (bestOfFirstToSel == 0) {
            if (scores.bestOfNum % 2 == 0) {
                ++scores.bestOfNum
            }

            scores.bestOfNum = (scores.bestOfNum + 1) / 2
        }

        val context = v!!.context
        val intent = Intent(context, RandomActivity::class.java)
        context!!.startActivity(intent)
        activity.finish()
    }
}