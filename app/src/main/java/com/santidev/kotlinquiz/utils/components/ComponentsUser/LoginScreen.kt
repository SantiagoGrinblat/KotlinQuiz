package com.santidev.kotlinquiz.utils.components.ComponentsUser

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.santidev.kotlinquiz.utils.components.ButtonsApp.CustomButton

@Composable
fun LoginScreen() {
//  var email by remember { mutableStateOf("") }
//  var password by remember { mutableStateOf("") }
//  var passwordVisible by remember { mutableStateOf(false) }
//  var rememberMe by remember { mutableStateOf(false) }
  var imageUri by remember { mutableStateOf<Uri?>(null) }
  
  // Launcher para seleccionar imagen de galería
  val galleryLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent()
  ) { uri: Uri? ->
    imageUri = uri
  }
  
  Box(
    modifier = Modifier
      .fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      
      // Imagen de Perfil con botón de cámara
      Box(
        modifier = Modifier.size(150.dp),
        contentAlignment = Alignment.Center
      ) {
        // Imagen de perfil
        if (imageUri != null) {
          // Mostrar imagen seleccionada
          Image(
            painter = rememberAsyncImagePainter(imageUri),
            contentDescription = "Foto de perfil",
            modifier = Modifier
              .size(150.dp)
              .clip(CircleShape),
            contentScale = ContentScale.Crop
          )
        } else {
          // Placeholder con icono de usuario
          Box(
            modifier = Modifier
              .size(150.dp)
              .clip(CircleShape)
              .background(
                Brush.linearGradient(
                  colors = listOf(
                    Color(0xFF2196F3),
                    Color(0xFF9C27B0)
                  )
                )
              ),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Default.Person,
              contentDescription = null,
              tint = Color.White,
              modifier = Modifier.size(70.dp)
            )
          }
        }
        
        // Botón de cámara (abajo a la derecha)
        FloatingActionButton(
          onClick = {
            // Abrir galería
            galleryLauncher.launch("image/*")
          },
          modifier = Modifier
            .size(50.dp)
            .align(Alignment.BottomEnd),
          containerColor = Color.White,
          elevation = FloatingActionButtonDefaults.elevation(4.dp)
        ) {
          Icon(
            imageVector = Icons.Default.CameraAlt,
            contentDescription = "Seleccionar foto",
            tint = Color(0xFF2196F3),
            modifier = Modifier.size(30.dp)
          )
        }
      }
      
      Spacer(modifier = Modifier.height(24.dp))
      
      CustomButton()
    }
  }
}
