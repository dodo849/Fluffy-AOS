package com.example.fluffy_aos.model.question

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BcsSurvey(
    @Json(name = "questionType") val questionType: String,
    @Json(name = "questions") val questions: List<BcsQuestion>
)
