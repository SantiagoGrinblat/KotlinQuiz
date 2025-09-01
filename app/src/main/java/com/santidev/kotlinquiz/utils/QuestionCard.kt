package com.santidev.kotlinquiz.utils

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santidev.kotlinquiz.data.Question

@Composable
fun QuestionCard(
  question: Question,
  isCorrect: Boolean?,
  onAnswerDropped: (String) -> Unit,
  onNextQuestion: () -> Unit
) {
  var dropTargetBounds by remember { mutableStateOf<Rect?>(null) }
  var wasDroppedInTarget by remember { mutableStateOf(false) }
  
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      question.text,
      style = MaterialTheme.typography.titleLarge,
      fontSize = 21.sp,
      fontWeight = FontWeight.Bold,
      color = Color.White,
      textAlign = TextAlign.Center
    )
    
    Spacer(modifier = Modifier.height(16.dp))
    
    DropTargetArea(
      isCorrect = isCorrect,
      onBoundsChanged = { bounds ->
        dropTargetBounds = bounds
        Log.d("DropTarget", "Bounds updated: $bounds")
      }
    )
    
    Spacer(modifier = Modifier.height(16.dp))
    
    FlowRow(
      horizontalArrangement = Arrangement.spacedBy(12.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      question.options.forEach { option ->
        key(option + question.id) {
          DraggableOption(
            text = option,
            onDropped = { selected ->
              if (wasDroppedInTarget) {
                Log.d("QuestionCard", "Respuesta válida recibida: $selected")
                onAnswerDropped(selected)
                wasDroppedInTarget = false
              } else {
                Log.d("QuestionCard", "Respuesta ignorada (no se soltó en zona): $selected")
              }
            },
            dropTargetBounds = dropTargetBounds,
            onValidDrop = { wasDroppedInTarget = true }
          )
        }
      }
    }
    
    if (isCorrect != null) {
      Spacer(modifier = Modifier.height(12.dp))
      
      if (isCorrect == true) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
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
            .border(2.dp, Color(0xFF362348), RoundedCornerShape(16.dp))
            
            .padding(8.dp),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = question.explanation,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
          )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Button(
          onClick = { onNextQuestion() },
          modifier = Modifier
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
            text = "Siguiente",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
          )
        }
      }
    }
  }
}
