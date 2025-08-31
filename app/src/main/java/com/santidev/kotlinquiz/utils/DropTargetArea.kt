package com.santidev.kotlinquiz.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DropTargetArea(
  modifier: Modifier = Modifier,
  isCorrect: Boolean? = null,
) {
  /*var targetBounds by remember { mutableStateOf<Rect?>(null) }*/
  
  val textValue = when (isCorrect) {
    true -> "Respuesta correcta ✅"
    false -> "Respuesta Incorrecta ❌"
    else -> "Arrastra aquí la respuesta"
  }
  
  Box(
    modifier = modifier
      .size(250.dp, 80.dp)
      .background(
        brush = Brush.linearGradient(
          colors = listOf(Color(0xFF2A1A3E), Color(0xFF1A1122)),
          start = Offset(0f, 0f),
          end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
        ),
        shape = RoundedCornerShape(16.dp)
      )
      .border(2.dp, Color(0xFF362348), RoundedCornerShape(16.dp)),
/*      .onGloballyPositioned { coords ->
        val pos = coords.localToWindow(Offset.Zero)
        targetBounds = Rect(
          pos.x,
          pos.y,
          pos.x + coords.size.width,
          pos.y + coords.size.height
        )
      },*/
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = textValue,
      color = Color.White,
      fontWeight = FontWeight.Bold,
      overflow = TextOverflow.Ellipsis,
      textAlign = TextAlign.Center
    )
  }
}
