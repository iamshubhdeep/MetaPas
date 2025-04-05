package com.metapass.ui

import android.app.AlertDialog
import android.content.Context

class ScorePopup(private val context: Context) {

    fun showTrustScore(score: Int) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Privacy Trust Score")
        builder.setMessage("Your trust score: $score/100")
        builder.setPositiveButton("OK", null)
        builder.show()
    }
}
