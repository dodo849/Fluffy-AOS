package com.example.fluffy_aos.model.question

import com.example.fluffy_aos.ui.common.question.display_model.QuestionDisplayModel
import com.example.fluffy_aos.ui.common.question.display_model.QuestionOrder
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BcsQuestionModel(
    @Json(name = "fieldName") val fieldName: String,
    @Json(name = "order") val order: Int,
    @Json(name = "description") val description: String,
    @Json(name = "responseType") val responseType: String,
    @Json(name = "responseSuffix") val responseSuffix: String,
    @Json(name = "selections") val selections: List<SelectionModel>
) {
    fun mapToDisplayModel(listSize: Int = 2): QuestionDisplayModel {
        assert(listSize >= 2) { "질문 문항은 2개 이상이어야합니다" }

        return QuestionDisplayModel(
            fieldName = fieldName,
            order = if (order == listSize) {
                QuestionOrder.LAST
            } else if (order == 1) {
                QuestionOrder.FIRST
            } else {
                QuestionOrder.NOTHING
            },
            description = description,
            responseType = responseType,
            selections = selections.map { it.mapToDisplayModel() }
        )
    }
}