package com.santidev.kotlinquiz.utils

import android.app.Activity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

//oculta las barras
fun Activity.hideSystemBars() {
  val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
  
  windowInsetsController?.apply {
    hide(WindowInsetsCompat.Type.systemBars())
    systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
  }
}

//muestra las barras
fun Activity.showSystemBars() {
  val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
  windowInsetsController?.show(WindowInsetsCompat.Type.systemBars())
}