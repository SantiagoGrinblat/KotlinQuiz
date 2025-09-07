package com.santidev.kotlinquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.santidev.kotlinquiz.ui.screen.QuizScreen
import com.santidev.kotlinquiz.ui.theme.KotlinQuizTheme
import com.santidev.kotlinquiz.utils.DetailedMenu

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      KotlinQuizTheme {
        DetailedMenu { paddingValues ->
          Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
          ) {
            QuizScreen()
          }
        }
      }
    }
  }
}
