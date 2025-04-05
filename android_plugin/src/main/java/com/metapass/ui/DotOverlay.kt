package com.metapass.ui

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView

class DotOverlay(context: Context) {
    
    private val overlayView = TextView(context).apply {
        text = "●"
        textSize = 30f
        setTextColor(Color.RED)
        gravity = Gravity.TOP or Gravity.END
    }

    private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private val layoutParams = WindowManager.LayoutParams(
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
        1
    )

    fun showOverlay() {
        windowManager.addView(overlayView, layoutParams)
    }

    fun hideOverlay() {
        windowManager.removeView(overlayView)
    }
}
