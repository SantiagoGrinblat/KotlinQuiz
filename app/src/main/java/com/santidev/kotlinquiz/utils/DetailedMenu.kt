package com.santidev.kotlinquiz.utils

import FilteredList
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.util.Collections.list

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedMenu(
  content: @Composable (PaddingValues) -> Unit
) {
  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val scope = rememberCoroutineScope()
  
  ModalNavigationDrawer(
    drawerContent = {
      ModalDrawerSheet {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              brush = Brush.linearGradient(
                colors = listOf(
                  Color(0xFF2A1A3E),
                  Color(0xFF1A1122)
                ),
                start = Offset(0f, 0f),
                end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
              )
            )
            .border(2.dp, Color(0xFF362348), RoundedCornerShape(16.dp))
        ) {
          Column(modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
          ) {
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
              "Categorias",
              modifier = Modifier.padding(16.dp),
              style = MaterialTheme.typography.titleLarge
            )
            
            HorizontalDivider()
            
            FilteredList()
            
            HorizontalDivider()
            
            Spacer(Modifier.height(12.dp))
          }
        }
      }
    },
    drawerState = drawerState
  ) {
    Box(modifier = Modifier.fillMaxSize()) {
      
      content(PaddingValues(0.dp))
      
      FloatingActionButton(
        onClick = {
          scope.launch {
            if (drawerState.isClosed) {
              drawerState.open()
            } else {
              drawerState.close()
            }
          }
        },
        containerColor = Color(0xFF2A1A3E),
        modifier = Modifier
          .align(Alignment.BottomEnd)
          .padding(16.dp)
          .border(
            width = 2.dp,
            brush = Brush.horizontalGradient(
              colors = listOf(Color(0xFF8A2BE2), Color(0xFFFF7F50))
            ),
            shape = RoundedCornerShape(16.dp)
          )
      ) {
        Icon(Icons.Default.Menu, contentDescription = "Abrir menú")
      }
    }
  }
}