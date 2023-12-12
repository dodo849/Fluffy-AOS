package com.example.fluffy_aos.model.predict

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PredictRequestDto(
    @Json(name = "values") val values: List<PredictItem>
)

data class PredictItem(
    @Json(name = "field_name") val fieldName: String,
    @Json(name = "value") val value: Int,
)
