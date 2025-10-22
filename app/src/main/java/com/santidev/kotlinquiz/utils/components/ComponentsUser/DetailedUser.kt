package com.santidev.kotlinquiz.utils.components.ComponentsUser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.santidev.kotlinquiz.utils.components.ButtonsApp.ButtonBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedUser(onNavigateBack: () -> Unit) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(
        brush = Brush.linearGradient(
          colors = listOf(
            Color(0xFF2A1A3E),
            Color(0xFF1A1122)
          ),
          start = Offset(0f, 0f),
          end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
        )
      )
  ) {
    ButtonBack(onNavigateBack = onNavigateBack)
    
    LoginScreen()
  }
}