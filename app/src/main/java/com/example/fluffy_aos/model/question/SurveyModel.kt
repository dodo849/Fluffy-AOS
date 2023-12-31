package com.example.fluffy_aos.model.question

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyModel(
    @Json(name = "questionType") val questionType: String,
    @Json(name = "questions") val questions: List<QuestionModel>
)
