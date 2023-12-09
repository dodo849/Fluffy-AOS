package com.example.fluffy_aos.data.repository

import android.content.ContentValues
import com.example.fluffy_aos.data.db.DbManager
import com.example.fluffy_aos.model.question.SurveyModel
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader

class BcsRepository(
    private val jsonReader: JsonReader = JsonReader,
    private val jsonParser: JsonParser<SurveyModel> = JsonParser(),
    private val dbManager: DbManager = DbManager
) {

    fun getBcsPhotoSurvey(): SurveyModel? {
        val jsonString = jsonReader.readJsonFile("bcs_photo_survey")
        return jsonParser.parse(jsonString, SurveyModel::class.java)
    }
    fun getBcsSurvey(): SurveyModel? {
        val jsonString = jsonReader.readJsonFile("bcs_survey")
        return jsonParser.parse(jsonString, SurveyModel::class.java)
    }

    fun readAllBcs(): Map<String, Any> {
        val bcsMap = mutableMapOf<String, Any>()
        val db = dbManager.getWritableDatabase()

        db.use {
            val cursor = it.query(
                "bcs",
                null,
                null,
                null,
                null,
                null,
                null
            )

            cursor?.use { cursor ->
                while (cursor.moveToNext()) {
                    val id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"))
                    val weight = cursor.getDouble(cursor.getColumnIndexOrThrow("weight"))
                    val shoulderHeight = cursor.getDouble(cursor.getColumnIndexOrThrow("shoulder_height"))
                    val neckSize = cursor.getDouble(cursor.getColumnIndexOrThrow("neck_size"))
                    val backLength = cursor.getDouble(cursor.getColumnIndexOrThrow("back_length"))
                    val chestSize = cursor.getDouble(cursor.getColumnIndexOrThrow("chest_size"))
                    val exerciseSelection = cursor.getInt(cursor.getColumnIndexOrThrow("exercise_selection"))
                    val environmentSelection = cursor.getInt(cursor.getColumnIndexOrThrow("environment_selection"))
                    val bowelCondition = cursor.getDouble(cursor.getColumnIndexOrThrow("bowel_condition"))
                    val foodCount = cursor.getInt(cursor.getColumnIndexOrThrow("food_count"))
                    val foodAmount = cursor.getDouble(cursor.getColumnIndexOrThrow("food_amount"))
                    val snackAmount = cursor.getDouble(cursor.getColumnIndexOrThrow("snack_amount"))
                    val foodKind = cursor.getInt(cursor.getColumnIndexOrThrow("food_kind"))

                    bcsMap["_id"] = id
                    bcsMap["weight"] = weight
                    bcsMap["shoulder-height"] = shoulderHeight
                    bcsMap["neck-size"] = neckSize
                    bcsMap["back-length"] = backLength
                    bcsMap["chest-size"] = chestSize
                    bcsMap["exercise-selection"] = exerciseSelection
                    bcsMap["environment-selection"] = environmentSelection
                    bcsMap["bowel-condition"] = bowelCondition
                    bcsMap["food-count"] = foodCount
                    bcsMap["food-amount"] = foodAmount
                    bcsMap["snack-amount"] = snackAmount
                    bcsMap["food-kind"] = foodKind
                }
            }
        }

        return bcsMap
    }

    fun insertBcs(result: Map<String, Any>): Long {
        val db = dbManager.getWritableDatabase()

        val values = ContentValues().apply {
            put("weight", (result["weight"] as? Double) ?: 0.0)
            put("shoulder_height", (result["shoulder-height"] as? Double) ?: 0.0)
            put("neck_size", (result["neck-size"] as? Double) ?: 0.0)
            put("back_length", (result["back-length"] as? Double) ?: 0.0)
            put("chest_size", (result["chest-size"] as? Double) ?: 0.0)
            put("exercise_selection", (result["exercise"] as? Int) ?: 0)
            put("environment_selection", (result["environment"] as? Int) ?: 0)
            put("bowel_condition", (result["bowel-condition"] as? Double) ?: 0.0)
            put("food_count", (result["food-count"] as? Int) ?: 0)
            put("food_amount", (result["food-amount"] as? Double) ?: 0.0)
            put("snack_amount", (result["snack-amount"] as? Double) ?: 0.0)
            put("food_kind", (result["food-kind"] as? Int) ?: 0)
        }


        return db.insert("pet", null, values)
    }

}