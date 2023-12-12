package com.example.fluffy_aos.model.predict

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PredictResponseDto(
    val bcs: Int
)