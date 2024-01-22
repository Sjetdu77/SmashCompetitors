package com.classes.smashcompetitors.mainactivity

import android.app.Activity
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import com.example.smashcompetitors.R
import com.classes.smashcompetitors.bestOfFirstToSel

class BOFTListener : Activity(), AdapterView.OnItemSelectedListener {
    lateinit var numBestOfFirstTo: EditText

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var num = numBestOfFirstTo.text.toString().toInt()

        if (bestOfFirstToSel == 0) {
            if (num % 2 == 1) {
                num++
            }
            num = (num + 1) / 2
        }
        bestOfFirstToSel = position
        if (bestOfFirstToSel == 0) {
            num = num * 2 - 1
        }

        numBestOfFirstTo.setText(num.toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        val bestOfFirstTo : Spinner = findViewById(R.id.boft)
        bestOfFirstTo.setSelection(bestOfFirstToSel)
    }
}