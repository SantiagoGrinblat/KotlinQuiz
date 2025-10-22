package com.santidev.kotlinquiz.utils.components.ComponentsQuiz

import com.santidev.kotlinquiz.data.QuestionCategory

data class GridItemWithDrawable(
  val name: String,
  val drawableResId: Int,
  val category : QuestionCategory
)