package com.example.fluffy_aos.model.question

import com.example.fluffy_aos.ui.common.survey.display_model.SelectionDisplayModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SelectionModel(
    @Json(name = "order") val order: Int,
    @Json(name = "code") val code: String,
    @Json(name = "description") val description: String
) {
    fun mapToDisplayModel(): SelectionDisplayModel {
        return SelectionDisplayModel(
            order = order,
            description = description,
            value = code.toInt()
        )
    }
}