package com.santidev.kotlinquiz.utils.components

import android.system.Os.close
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ButtonMenu(
  onMenuClick: () -> Unit, // Cambiamos a una lambda
  content: @Composable (PaddingValues) -> Unit,
) {
  Box(modifier = Modifier.fillMaxSize()) {
    
    content(PaddingValues(0.dp))
    
    FloatingActionButton(
      onClick = onMenuClick, // Simplemente llamamos la lambda
      containerColor = Color(0xFF2A1A3E),
      modifier = Modifier
        .align(Alignment.BottomEnd)
        .padding(16.dp)
        .navigationBarsPadding()
        .border(
          width = 2.dp,
          brush = Brush.horizontalGradient(
            colors = listOf(Color(0xFF8A2BE2), Color(0xFFFF7F50))
          ),
          shape = RoundedCornerShape(16.dp)
        ),
    ) {
      Icon(Icons.Default.Menu, contentDescription = "Abrir menú", tint = Color.White)
    }
  }
}