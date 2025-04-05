package com.metapass.services

import android.content.Context
import android.media.AudioManager
import android.os.Build
import android.util.Log

class PermissionWatcher(private val context: Context) {
    
    fun checkMicAccess(): Boolean {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioManager.isMicrophoneMute
        } else {
            false
        }
    }

    fun checkCameraAccess(): Boolean {
        // Simulated check (can be improved with actual sensor monitoring)
        return false
    }

    fun checkLocationAccess(): Boolean {
        val prefs = context.getSharedPreferences("MetaPassPrefs", Context.MODE_PRIVATE)
        return prefs.getBoolean("LocationAccess", false)
    }
}
