package com.santidev.kotlinquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.santidev.kotlinquiz.ui.screen.QuizScreen
import com.santidev.kotlinquiz.ui.theme.KotlinQuizTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      KotlinQuizTheme {
        QuizScreen()
      }
    }
  }
}
