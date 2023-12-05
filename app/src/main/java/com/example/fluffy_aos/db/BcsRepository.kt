package com.example.fluffy_aos.db

import com.example.fluffy_aos.model.question.BcsSurvey
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader

class BcsRepository(
    private val jsonReader: JsonReader,
    private val jsonParser: JsonParser<BcsSurvey>
) {
    fun getBcsSurvey(): BcsSurvey? {
        val jsonString = jsonReader.readJsonFile("bcs_survey")
        println("bcs_survey.json: $jsonString")
        return jsonParser.parse(jsonString, BcsSurvey::class.java)
    }

}