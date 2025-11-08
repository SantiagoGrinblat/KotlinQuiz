package com.santidev.kotlinquiz.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.santidev.kotlinquiz.data.QuestionRepository
import com.santidev.kotlinquiz.utils.components.ComponentsQuiz.DetailedMenu
import com.santidev.kotlinquiz.utils.components.ComponentsQuiz.QuestionCard

@Composable
fun QuizScreen(navigateToUser: () -> Unit) {
  
  val context = LocalContext.current
  val allQuestions = remember {
    QuestionRepository(context).loadQuestions()
  }
  
  var currentQuestionIndex by remember { mutableStateOf(0) }
  var isCorrect by remember { mutableStateOf<Boolean?>(null) }
  var selectedAnswer by remember { mutableStateOf<String?>(null) }
  var selectedCategory by remember { mutableStateOf<String?>(null) }
  
  val questionsRandom = remember(selectedCategory, allQuestions) {
    if (selectedCategory == null) {
      allQuestions.shuffled()
    } else {
      allQuestions.filter { it.category == selectedCategory }.shuffled()
    }
  }
  
  LaunchedEffect(selectedCategory) {
    currentQuestionIndex = 0
    isCorrect = null
    selectedAnswer = null
  }
  
  val totalQuestions = questionsRandom.size
  
  DetailedMenu(
    selectedCategory = selectedCategory,
    onCategorySelected = { category ->
      selectedCategory = category
    }
  ) { paddingValues ->
    if (questionsRandom.isNotEmpty()) {
      val currentQuestions = questionsRandom[currentQuestionIndex]
      Column(
        modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFF1A1122))
          .padding(paddingValues)
          .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        
        Text(text = "Pregunta ${currentQuestionIndex + 1} de ${totalQuestions}", color = Color.Gray)
        
        QuestionCard(
          question = currentQuestions,
          isCorrect = isCorrect,
          //Antes estaba isCorrect = isCorrect == true, pero no funcionaba el texto que cambia.
          //tambien tuve que modificar el boolean de DropTargetArea y agregar el signo de interrogacion.
          //ademas de modificar el if del archivo QuestionCard : if (isCorrect != null) <- para que me tome la respuesat inicial siempre como null.
          selectedAnswer = selectedAnswer,
          onAnswerDropped = { selected ->
            selectedAnswer = selected
            isCorrect = selected == currentQuestions.correctAnswer
          },
          onNextQuestion = {
            if (currentQuestionIndex < questionsRandom.size - 1) {
              currentQuestionIndex++
              isCorrect = null
              selectedAnswer = null
            } else {
              currentQuestionIndex = 0
              isCorrect = null
              selectedAnswer = null
            }
          },
        )
      }
    }
  }
}