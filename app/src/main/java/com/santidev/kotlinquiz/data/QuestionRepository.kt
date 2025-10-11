package com.santidev.kotlinquiz.data

import android.content.Context
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class QuestionRepository(private val context: Context) {
  
  private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
  }
  
  fun loadQuestions(): List<Question> {
    return try {
      val jsonString = context.assets.open("Questions.json")
        .bufferedReader()
        .use { it.readText() }
      
      json.decodeFromString(
        ListSerializer(Question.serializer()),
        jsonString
      )
    } catch (e: Exception) {
      e.printStackTrace()
      emptyList()
    }
  }
}