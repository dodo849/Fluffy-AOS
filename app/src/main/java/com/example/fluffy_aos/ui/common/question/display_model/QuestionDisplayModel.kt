package com.example.fluffy_aos.ui.common.question.display_model

data class QuestionDisplayModel(
    val fieldName: String,
    val order: QuestionOrder,
    val description: String,
    val responseType: String,
    val selections: List<SelectionDisplayModel>
)
