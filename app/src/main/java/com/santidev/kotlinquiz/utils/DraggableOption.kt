package com.santidev.kotlinquiz.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun DraggableOption(
  text: String,
  onDropped: (String) -> Unit
) {
  var offsetX by remember { mutableStateOf(0f) }
  var offsetY by remember { mutableStateOf(0f) }
  
  Box(modifier = Modifier
    .offset{ IntOffset (offsetX.toInt(), offsetY.toInt() ) }
    .border(
      width = 2.dp,
      brush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF8A2BE2), Color(0xFFFF7F50))
      ),
      shape = RoundedCornerShape(16.dp)
    )
    .background(brush = Brush.linearGradient(
      colors = listOf(
        Color(0xFF2A1A3E),
        Color(0xFF1A1122)
      ),
      start = Offset(0f, 0f),
      end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    ),
      shape = RoundedCornerShape(16.dp)
  )
    .padding(16.dp)
    .pointerInput(Unit) {
      detectDragGestures(
        onDragEnd = { onDropped(text) }
      ) { change, dragAmount ->
        change.consume()
        offsetX += dragAmount.x
        offsetY += dragAmount.y
      }
    }
  ) {
    Text(text , color = Color.White, fontWeight = FontWeight.SemiBold)
  }
}
