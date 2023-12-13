package com.example.fluffy_aos.model.pet

import com.example.fluffy_aos.model.question.SurveyModel
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader

class PetConverter(
    private val jsonReader: JsonReader = JsonReader,
    private val jsonParser: JsonParser<SurveyModel> = JsonParser()
) {

    companion object {
        val selectionFields = listOf("species", "breed", "furType", "sex")
    }

    fun codeToDescriptionByPet(pet: Pet): Pet {
        return Pet(
            name = pet.name,
            species = codeToDescriptionByField("species", pet.species),
            breed = codeToDescriptionByField("breed", pet.breed),
            furType = codeToDescriptionByField("furType", pet.furType),
            age = pet.age,
            sex = codeToDescriptionByField("sex", pet.sex),
        )
    }

    fun orderToCodeByField(fieldName: String, order: Int): String {
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

    fun codeToOrderByField(fieldName: String, code: String): Int {
        val jsonString = jsonReader.readJsonFile("onboarding_survey")
        val surveyModel = jsonParser.parse(jsonString, SurveyModel::class.java) ?: return -1

        val selectedOrder = surveyModel.questions
            .filter { it.fieldName == fieldName }
            .flatMap { it.selections }
            .firstOrNull { it.code == code }
            ?.order

        return selectedOrder ?: -1
    }

    fun codeToDescriptionByField(fieldName: String, code: String): String {
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

    fun descriptionToOrderByField(fieldName: String, description: String): Int {
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
