package com.example.fluffy_aos.data.repository

import com.example.fluffy_aos.model.predict.PredictRequestDto
import com.example.fluffy_aos.model.predict.PredictResponseDto
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking


class PredictRepository {
    suspend fun sendHttpPostRequest(requestBody: PredictRequestDto): PredictResponseDto? {
        val url = "http://10.0.2.2:8000/predict"

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val jsonAdapter = moshi.adapter(PredictRequestDto::class.java)
        val json = jsonAdapter.toJson(requestBody)
        println("request json = ${json}")

        val (request, response, result) = Fuel
            .post(url)
            .header("Content-Type" to "application/json")
            .body(json)
            .awaitStringResponseResult()

        return result.fold(
            success = { data ->
                val responseAdapter = moshi.adapter(PredictResponseDto::class.java)
                responseAdapter.fromJson(data)
            },
            failure = { error ->
                println("An error of type ${error.exception} happened: ${error.message}")
                null // 오류가 발생하면 null 반환
            }
        )
    }

}