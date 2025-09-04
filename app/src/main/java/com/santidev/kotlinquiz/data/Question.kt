package com.santidev.kotlinquiz.data

import kotlinx.serialization.Serializable

@Serializable
data class Question(
  val id: Int,
  val text: String,
  val options: List<String>,
  val correctAnswer: String,
  val explanation : String = "",
  val category: String,
)

enum class QuestionCategory(val displayName: String) {
  FUNDAMENTALS("Fundamentos Kotlin"),
  COMPOSE("Jetpack compose"),
  ADVANCED("Conceptos Avanzados"),
  POO("Programación Orientada a Objetos")
}