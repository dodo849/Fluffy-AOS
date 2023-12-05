package com.example.fluffy_aos.model.question

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BcsQuestion(
    @Json(name = "fieldName") val fieldName: String,
    @Json(name = "order") val order: Int,
    @Json(name = "description") val description: String,
    @Json(name = "responseType") val responseType: String,
    @Json(name = "selections") val selections: List<SelectionItem>
)