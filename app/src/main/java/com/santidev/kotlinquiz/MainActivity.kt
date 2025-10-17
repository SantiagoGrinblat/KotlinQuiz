package com.santidev.kotlinquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.santidev.kotlinquiz.navigation.NavigationWrapper
import com.santidev.kotlinquiz.ui.theme.KotlinQuizTheme
import com.santidev.kotlinquiz.utils.hideSystemBars

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    hideSystemBars()
    enableEdgeToEdge()
    setContent {
      KotlinQuizTheme {
        NavigationWrapper()
      }
    }
  }
  
  override fun onResume() {
    super.onResume()
//    hideSystemBars()
  }
}