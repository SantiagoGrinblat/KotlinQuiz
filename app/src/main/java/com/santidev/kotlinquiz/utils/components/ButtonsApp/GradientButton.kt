package com.santidev.kotlinquiz.utils.components.ButtonsApp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = Color.Transparent
    ),
    contentPadding = PaddingValues(),
    modifier = modifier
      .background(
        brush = Brush.linearGradient(
          colors = listOf(
            Color(0xFF2A1A3E),
            Color(0xFF1A1122)
          ),
          start = Offset(0f, 0f),
          end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
        ),
        shape = RoundedCornerShape(16.dp)
      )
      .border(
        width = 2.dp,
        brush = Brush.horizontalGradient(
          colors = listOf(Color(0xFF8A2BE2), Color(0xFFFF7F50))
        ),
        shape = RoundedCornerShape(16.dp)
      )
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.titleLarge,
      color = Color.White,
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
  }
}
