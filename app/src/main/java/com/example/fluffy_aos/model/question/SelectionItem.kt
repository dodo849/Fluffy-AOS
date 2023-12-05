package com.example.fluffy_aos.model.question

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SelectionItem(
    @Json(name = "order") val order: Int,
    @Json(name = "code") val code: String,
    @Json(name = "description") val description: String
)