package com.santidev.kotlinquiz.utils

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
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
  
  //test para ver si la categoria es seleccionada
  @Test
  fun whenNoCategory_filterTextIsNotDisplayed() {
    composeTestRule.setContent {
      DetailedMenu(
        selectedCategory = null,
        onCategorySelected = {},
        content = {}
      )
    }
   
   composeTestRule
     .onNodeWithText("Filtro activado:", substring = true)
     .assertDoesNotExist()
  }
  
  //test para comprobar que se borre los filtros de categorias
  @Test
  fun clickingClearButton_invokesCallbackWithNull() {
    var capturedCategory: String? = "initial"
    
    composeTestRule.setContent {
      DetailedMenu(
        selectedCategory = "Jetpack compose",
        onCategorySelected = {capturedCategory = it},
        content = {}
      )
    }
    
    composeTestRule
      .onNodeWithContentDescription("Abrir menú")
      .performClick()
    
    composeTestRule
      .onNodeWithText("Mostrar todas las categorías")
      .performClick()
    
    assert(capturedCategory == null)
  }
  
}