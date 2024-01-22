package com.classes.smashcompetitors.counterpickactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.classes.smashcompetitors.scores
import com.classes.smashcompetitors.step
import com.example.smashcompetitors.R

class CounterpickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counterpick)

        step = 1

        val p1 : Button = findViewById(R.id.confirm_p1)
        val p2 : Button = findViewById(R.id.confirm_p2)
        val victorious = intent.extras!!.getInt("Victorious")
        val toDraw = if (victorious == 1) R.drawable.p1_center else R.drawable.p2_center
        val buttonToClick = if (victorious == 1) p1 else p2
        val layout : ConstraintLayout = findViewById(R.id.background_app)
        val matches : TextView = findViewById(R.id.matches)
        val allStages : Array<ImageButton> = arrayOf(
            findViewById(R.id.bf),
            findViewById(R.id.sbf),
            findViewById(R.id.fd),
            findViewById(R.id.sv),
            findViewById(R.id.ps2),
            findViewById(R.id.yoshi),
            findViewById(R.id.kalos),
            findViewById(R.id.tc),
            findViewById(R.id.hb)
        )

        buttonToClick.visibility = View.VISIBLE
        buttonToClick.isClickable = true
        matches.text = scores.bestOfNum.toString()

        layout.setBackgroundResource(toDraw)

        for (stage in allStages) {
            stage.setOnClickListener(StageListener(buttonToClick, allStages))
        }

        p1.setOnClickListener(ConfirmListener(this, p2, R.drawable.p2_center))
        p2.setOnClickListener(ConfirmListener(this, p1, R.drawable.p1_center))
    }
}