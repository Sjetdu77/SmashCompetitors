package com.classes.smashcompetitors.counterpickactivity

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.classes.smashcompetitors.scores
import com.classes.smashcompetitors.step

class StageListener(private var player: Button, private var allFirstStages : Array<ImageButton>) :
    View.OnClickListener {
    override fun onClick(v: View?) {
        v as ImageButton

        if (scores.getAllScores() == "0 - 0") {
            when (step) {
                1 -> {
                    addOrRemove(player, v, 3)
                }
                2 -> {
                    addOrRemove(player, v, 4)
                }
                3 -> {
                    choose(allFirstStages, player, v)
                }
            }
        } else when (step) {
            1 -> {
                addOrRemove(player, v, 3)
            }
            2 -> {
                choose(allFirstStages, player, v)
            }
        }
    }
}