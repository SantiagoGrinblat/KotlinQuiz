package com.santidev.kotlinquiz.utils.components.ButtonsApp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonUsers(onClick: () -> Unit) {
  Box(modifier = Modifier.fillMaxWidth()) {
    FloatingActionButton(
      onClick = onClick,
      containerColor = Color(0xFF2A1A3E),
      shape = CircleShape,
      modifier = Modifier
        .align(Alignment.TopEnd)
        .padding(16.dp)
        .navigationBarsPadding()
        .border(
          width = 2.dp,
          brush = Brush.horizontalGradient(
            colors = listOf(Color(0xFF8A2BE2), Color(0xFFFF7F50))
          ),
          shape = CircleShape
        ),
    ) {
      Icon(Icons.Default.Person, contentDescription = "Abrir menú Personal", tint = Color.White)
    }
  }
}