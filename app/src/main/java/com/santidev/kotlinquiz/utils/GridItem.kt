package com.santidev.kotlinquiz.utils

import com.santidev.kotlinquiz.data.QuestionCategory

data class GridItemWithDrawable(
  val name: String,
  val drawableResId: Int,
  val category : QuestionCategory
)