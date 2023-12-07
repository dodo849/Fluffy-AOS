package com.example.fluffy_aos.model.question

import com.example.fluffy_aos.ui.common.survey.display_model.QuestionDisplayModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuestionModel(
    @Json(name = "fieldName") val fieldName: String,
    @Json(name = "order") val order: Int,
    @Json(name = "description") val description: String,
    @Json(name = "responseType") val responseType: String,
    @Json(name = "responseSuffix") val responseSuffix: String,
    @Json(name = "selections") val selections: List<SelectionModel>
) {
    fun mapToDisplayModel(): QuestionDisplayModel {

        return QuestionDisplayModel(
            fieldName = fieldName,
            order = order,
            description = description,
            responseType = responseType,
            responseSuffix = responseSuffix,
            selections = selections.map { it.mapToDisplayModel() }
        )
    }
}