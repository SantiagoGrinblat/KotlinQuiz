package com.santidev.kotlinquiz.data

data class Question(
  val id: Int,
  val text: String,
  val options: List<String>,
  val correctAnswer: String,
  val explanation : String = "",
  /*val category: String = "General"*/
)
