package com.example.fluffy_aos.data.repository

import android.content.ContentValues
import com.example.fluffy_aos.data.db.DbManager
import com.example.fluffy_aos.model.question.SurveyModel
import com.example.fluffy_aos.util.JsonParser
import com.example.fluffy_aos.util.JsonReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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

    fun readBcsByPet(petId: Long): Map<Date, Map<String, String>> {
        val bcsMaps = mutableMapOf<Date, Map<String, String>>()
        val db = dbManager.getWritableDatabase()

        db.use {
            val cursor = it.query(
                "bcs",
                null,
                "pet_id = ?",
                arrayOf(petId.toString()),
                null,
                null,
                null
            )

            cursor?.use { cursor ->
                while (cursor.moveToNext()) {
                    val date = parseDate(cursor.getString(cursor.getColumnIndexOrThrow("date")))
                    val fieldName = cursor.getString(cursor.getColumnIndexOrThrow("field_name"))
                    val value = cursor.getString(cursor.getColumnIndexOrThrow("value"))

                    val existingMap = bcsMaps[date]?.toMutableMap()
                    if (existingMap == null) {
                        // 해당 날짜에 대한 맵이 없으면 새로 생성하여 값 추가
                        val newMap = mutableMapOf(fieldName to value)
                        bcsMaps[date] = newMap
                    } else {
                        // 이미 해당 날짜에 대한 맵이 있으면 기존 맵에 값 추가
                        existingMap[fieldName] = value
                        bcsMaps[date] = existingMap
                    }
                }
            }
        }

        return bcsMaps.toMap()
    }

    fun saveBcs(petId: Long, bcs: Map<String, Any>) {
        val db = dbManager.getWritableDatabase()

        val currentDate = getCurrentDate()

        bcs.forEach() { (key, value) ->
            val values = ContentValues().apply {
                put("pet_id", petId)
                put("date", currentDate)
                put("field_name", key)
                put("value", value.toString())
            }
            db.insert("bcs", null, values)
        }
    }

    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.format(Date())
    }

    private fun parseDate(dateString: String): Date {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.parse(dateString) ?: Date()
    }
}

//"_id integer primary key autoincrement," +
//"pet_id integer," +
//"date text," +
//"field_name text," +
//"value text" +
//");"