package com.classes.smashcompetitors.counterpickactivity

import android.widget.Button
import android.widget.ImageButton
import com.classes.smashcompetitors.banned
import com.classes.smashcompetitors.chosen
import com.example.smashcompetitors.R

fun addOrRemove(player: Button, v : ImageButton, size : Int) {
    if (chosen.contains(v)) {
        v.setBackgroundResource(R.drawable.button_white)
        chosen.remove(v)
    } else if (chosen.size < size) {
        v.setBackgroundResource(R.drawable.button_gold)
        chosen.add(v)
    }

    player.isClickable = chosen.size == size
}

fun choose(allFirstStages : Array<ImageButton>, player: Button, v : ImageButton) {
    chosen.clear()
    for (stage in allFirstStages) {
        if (!banned.contains(stage)) {
            stage.setBackgroundResource(R.drawable.button_white)
        }
    }
    v.setBackgroundResource(R.drawable.button_gold)
    chosen.add(v)

    player.isClickable = true
}