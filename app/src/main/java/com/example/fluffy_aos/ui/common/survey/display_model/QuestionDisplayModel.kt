package com.example.fluffy_aos.ui.common.survey.display_model

data class QuestionDisplayModel(
    val fieldName: String,
    val order: Int,
    val description: String,
    val responseType: String,
    val selections: List<SelectionDisplayModel>
)
