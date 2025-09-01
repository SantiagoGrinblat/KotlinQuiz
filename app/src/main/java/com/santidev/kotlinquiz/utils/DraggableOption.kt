package com.santidev.kotlinquiz.utils

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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
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
        Log.d("DragDrop", "Initial position for '$text': $initialPosition")
      }
    }
    .padding(16.dp)
    .pointerInput(Unit) {
      detectDragGestures(
        onDragStart = {
          isDragging = true
          Log.d("DragDrop", "Started dragging '$text'")
        },
        onDragEnd = {
          isDragging = false
          Log.d("DragDrop", "Drag ended for '$text'")
          
          // Verificamos si está dentro de la zona de destino
          dropTargetBounds?.let { bounds ->
            // Calculamos la posición actual del centro del elemento
            val currentElementX = initialPosition.x + offsetX + size.width / 2f
            val currentElementY = initialPosition.y + offsetY + size.height / 2f
            
            Log.d("DragDrop", "Element '$text' center: ($currentElementX, $currentElementY)")
            Log.d("DragDrop", "Target bounds: $bounds")
            
            // Verificamos si el centro está dentro de la zona de destino
            val isInTarget = currentElementX >= bounds.left &&
                currentElementX <= bounds.right &&
                currentElementY >= bounds.top &&
                currentElementY <= bounds.bottom
            
            Log.d("DragDrop", "Is in target: $isInTarget")
            
            if (isInTarget) {
              Log.d("DragDrop", "¡Elemento '$text' soltado correctamente en la zona!")
              onValidDrop() // Marcamos que fue un drop válido
              onDropped(text) // Enviamos la respuesta
            } else {
              Log.d("DragDrop", "Elemento '$text' soltado fuera de zona")
              // NO ejecutamos onDropped si está fuera
            }
          } ?: Log.d("DragDrop", "No hay bounds definidos para '$text'")
          
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
