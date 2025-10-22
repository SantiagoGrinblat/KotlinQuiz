package com.santidev.kotlinquiz.utils.components.ButtonsApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.santidev.kotlinquiz.R

@Composable
fun CustomButton() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(48.dp)
      .padding(horizontal = 32.dp)
      .background(
        Color.White,
        shape = RoundedCornerShape(16.dp)
      )
      .border(2.dp, Color(0xFF362348), RoundedCornerShape(16.dp)),
    contentAlignment = Alignment.CenterStart,
  ) {
    Image(
      painter = painterResource(id = R.drawable.logogoogle),
      contentDescription = "Google Login Button",
      modifier = Modifier
        .padding(start = 16.dp)
        .size(28.dp)
    )
    Text(
      text = "Continue with Google",
      fontWeight = FontWeight.Bold,
      color = Color.Black,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center,
    )
  }
}