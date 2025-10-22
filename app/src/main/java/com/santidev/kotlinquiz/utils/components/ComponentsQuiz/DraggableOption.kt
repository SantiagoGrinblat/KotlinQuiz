package com.santidev.kotlinquiz.utils.components.ComponentsQuiz

import android.util.Log
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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun DraggableOption(
  text: String,
  onDropped: (String) -> Unit,
  dropTargetBounds: Rect? = null,
  onValidDrop: () -> Unit = {},
) {
  
  var offsetX by remember { mutableStateOf(0f) }
  var offsetY by remember { mutableStateOf(0f) }
  var isDragging by remember { mutableStateOf(false) }
  var initialPosition by remember { mutableStateOf(Offset.Zero) }
  
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
    .onGloballyPositioned { coordinates ->
      if (initialPosition == Offset.Zero) {
        initialPosition = coordinates.positionInWindow()
        Log.d("DRAGDROP", "Initial position for '$text': $initialPosition")
      }
    }
    .padding(16.dp)
    .pointerInput(Unit) {
      detectDragGestures(
        onDragStart = {
          isDragging = true
        },
        onDragEnd = {
          isDragging = false
          
          // Verificamos si esta dentro de la zona de destino
          dropTargetBounds?.let { bounds ->
            // se verifica la posicion actual del centro del elemento
            val currentElementX = initialPosition.x + offsetX + size.width / 2f
            val currentElementY = initialPosition.y + offsetY + size.height / 2f
            
            // Verificamos si el centro esta dentro de la zona de destino
            val isInTarget = currentElementX >= bounds.left &&
                currentElementX <= bounds.right &&
                currentElementY >= bounds.top &&
                currentElementY <= bounds.bottom
            
            if (isInTarget) {
              onValidDrop() // se marca que fue un drop valido
              onDropped(text) // se envia la respuesta
            } else {
              Log.d("DRAGDROP", "Elemento '$text' soltado fuera de zona")
              // NO ejecutamos onDropped si esta fuera del area del elemento
            }
          } ?: Log.d("DRAGDROP", "No hay bounds definidos para '$text'")
          
          // Resetear posición
          offsetX = 0f
          offsetY = 0f
        }
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
