package com.santidev.kotlinquiz.utils

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class DetailedMenuKtTest {
  
  @get:Rule
  val composeTestRule = createComposeRule()
  
  //test para verificar si el boton del menu funciona correctamente
  @Test
  fun fabDisplayed() {
    composeTestRule.setContent {
      DetailedMenu(
        selectedCategory = null,
        onCategorySelected = {},
        content = {}
      )
    }
    composeTestRule
      .onNodeWithContentDescription("Abrir menú")
      .assertIsDisplayed()
  }
  
  
  
}