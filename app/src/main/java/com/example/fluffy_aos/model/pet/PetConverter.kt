package com.example.fluffy_aos.model.pet

import com.example.fluffy_aos.model.question.SurveyModel
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader

class PetConverter(
    private val jsonReader: JsonReader = JsonReader,
    private val jsonParser: JsonParser<SurveyModel> = JsonParser()
) {

    fun orderToCode(fieldName: String, order: Int): String {
        val jsonString = jsonReader.readJsonFile("onboarding_survey")
        val surveyModel = jsonParser.parse(
            jsonString,
            SurveyModel::class.java
        ) ?: return "알 수 없음"

        val selectedCode = surveyModel.questions
            .filter { it.fieldName == fieldName }
            .flatMap { it.selections }
            .firstOrNull { it.order == order }
            ?.code

        return selectedCode ?: return "알 수 없음"
    }

    fun codeToOrder(fieldName: String, code: String): Int? {
        val jsonString = jsonReader.readJsonFile("onboarding_survey")
        val surveyModel = jsonParser.parse(jsonString, SurveyModel::class.java) ?: return null

        val selectedOrder = surveyModel.questions
            .filter { it.fieldName == fieldName }
            .flatMap { it.selections }
            .firstOrNull { it.code == code }
            ?.order

        return selectedOrder
    }

    fun codeToDescription(fieldName: String, code: String): String {
        val jsonString = jsonReader.readJsonFile("onboarding_survey")
        val surveyModel = jsonParser.parse(
            jsonString,
            SurveyModel::class.java
        ) ?: return "알 수 없음"

        val selectedDescription = surveyModel.questions
            .filter { it.fieldName == fieldName }
            .flatMap { it.selections }
            .firstOrNull { it.code == code }
            ?.description

        return selectedDescription ?: return "알 수 없음"
    }

    fun descriptionToOrder(fieldName: String, description: String): Int {
        val jsonString = jsonReader.readJsonFile("onboarding_survey")
        val surveyModel = jsonParser.parse(
            jsonString,
            SurveyModel::class.java
        ) ?: return 0

        val selectedOrder = surveyModel.questions
            .filter { it.fieldName == fieldName }
            .flatMap { it.selections }
            .firstOrNull { it.description == description }
            ?.order

        return selectedOrder ?: return 0
    }
}
