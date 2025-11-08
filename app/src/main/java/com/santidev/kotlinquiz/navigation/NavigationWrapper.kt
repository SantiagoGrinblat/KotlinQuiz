package com.santidev.kotlinquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santidev.kotlinquiz.ui.screen.QuizScreen

@Composable
fun NavigationWrapper() {
  val navController = rememberNavController()
  
  NavHost(navController = navController, startDestination = Home) {
    composable<Home> {
      QuizScreen(
        navigateToUser = { navController.navigate(Home) }
      )
    }
  }
}