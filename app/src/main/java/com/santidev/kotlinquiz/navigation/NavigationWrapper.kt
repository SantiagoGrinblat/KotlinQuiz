package com.santidev.kotlinquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santidev.kotlinquiz.ui.screen.QuizScreen
import com.santidev.kotlinquiz.ui.screen.UserScreen

@Composable
fun NavigationWrapper() {
  val navController = rememberNavController()
  
  NavHost(navController = navController, startDestination = Home) {
    composable<Home> {
      QuizScreen(
        navigateToUser = { navController.navigate(User) }
      )
    }
    composable<User> {
      UserScreen(onNavigateBack = { navController.popBackStack() })
    }
  }
}