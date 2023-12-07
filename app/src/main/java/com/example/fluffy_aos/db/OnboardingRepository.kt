package com.example.fluffy_aos.db

import android.content.ContentValues
import com.example.fluffy_aos.model.question.SurveyModel
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader

class OnboardingRepository(
    private val jsonReader: JsonReader = JsonReader,
    private val jsonParser: JsonParser<SurveyModel> = JsonParser(),
) {
    fun getOnboardingSurvey(): SurveyModel? {
        val jsonString = jsonReader.readJsonFile("onboarding_survey")
        return jsonParser.parse(jsonString, SurveyModel::class.java)
    }
}