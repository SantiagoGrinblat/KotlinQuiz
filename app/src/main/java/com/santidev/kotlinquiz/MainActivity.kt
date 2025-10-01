package com.santidev.kotlinquiz

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.santidev.kotlinquiz.ui.screen.QuizScreen
import com.santidev.kotlinquiz.ui.theme.KotlinQuizTheme
import com.santidev.kotlinquiz.utils.DetailedMenu
import com.santidev.kotlinquiz.utils.hideSystemBars

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    hideSystemBars()
    enableEdgeToEdge()
    setContent {
      KotlinQuizTheme {
        QuizScreen()
      }
    }
  }
  
  override fun onResume() {
    super.onResume()
    hideSystemBars()
  }
}