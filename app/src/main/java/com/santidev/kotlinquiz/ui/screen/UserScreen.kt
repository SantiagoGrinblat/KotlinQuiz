package com.santidev.kotlinquiz.ui.screen

import androidx.compose.runtime.Composable
import com.santidev.kotlinquiz.utils.components.ComponentsUser.DetailedUser

@Composable
fun UserScreen(onNavigateBack: () -> Unit) {
  DetailedUser(onNavigateBack = onNavigateBack)
}