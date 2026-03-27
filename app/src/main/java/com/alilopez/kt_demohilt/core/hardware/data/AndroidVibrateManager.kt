package com.alilopez.kt_demohilt.core.hardware.data

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.annotation.RequiresPermission
import com.alilopez.kt_demohilt.core.hardware.domain.VibrateManager
import dagger.hilt.android.qualifiers.ApplicationContext

class AndroidVibrateManager(@ApplicationContext private val context: Context) : VibrateManager {
        private val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }

        @RequiresPermission(Manifest.permission.VIBRATE)
        override fun run() {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate( VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(500)
            }
        }
    }