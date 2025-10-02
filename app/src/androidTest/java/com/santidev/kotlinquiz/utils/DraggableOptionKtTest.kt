package com.santidev.kotlinquiz.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTouchInput
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class DraggableOptionKtTest {
  
  @get:Rule
  val composeTestRule = createComposeRule()
  
  @Test
  fun textIsDisplayedCorrectly() {
    composeTestRule.setContent {
      DraggableOption(
        text = "Opción 1",
        onDropped = {},
        dropTargetBounds = null
      )
    }
    
    composeTestRule
      .onNodeWithText("Opción 1")
      .assertIsDisplayed()
  }
  
  //test para verificar si las respuestas se mueven y si llegan al espacio en donde se debe colocar
  @Test
  fun onDropped_isCalledWithCorrectText_whenDroppedInsideBounds() {
    var droppedText: String? = null
    var validDropCalled = false
    
    // se define el area del movimiento
    val bounds = Rect(
      left = 100f,
      top = 100f,
      right = 300f,
      bottom = 300f
    )
    
    composeTestRule.setContent {
      DraggableOption(
        text = "Opción A",
        onDropped = { text -> droppedText = text },
        dropTargetBounds = bounds,
        onValidDrop = { validDropCalled = true }
      )
    }
    
    // simula que la pregunta haya llegado al destino
    composeTestRule
      .onNodeWithText("Opción A")
      .performTouchInput {
        down(Offset(0f, 0f))
        moveTo(Offset(200f, 200f)) // Dentro de bounds
        up()
      }
    
    // Verifica que se llamaron a los callbacks
    assertEquals("Opción A", droppedText)
    assertTrue(validDropCalled)
  }
  
  @Test
  fun onDropped_isNotCalled_whenDroppedOutsideBounds() {
    var droppedText: String? = null
    var validDropCalled = false
    
    val bounds = Rect(
      left = 100f,
      top = 100f,
      right = 300f,
      bottom = 300f
    )
    
    composeTestRule.setContent {
      DraggableOption(
        text = "Opción B",
        onDropped = { text -> droppedText = text },
        dropTargetBounds = bounds,
        onValidDrop = { validDropCalled = true }
      )
    }
    
    // Simular drag FUERA del area
    composeTestRule
      .onNodeWithText("Opción B")
      .performTouchInput {
        down(Offset(0f, 0f))
        moveTo(Offset(500f, 500f)) // Fuera de bounds
        up()
      }
    
    // Verificar que NO se llamaron los callbacks
    assertNull(droppedText)
    assertFalse(validDropCalled)
  }
  
}