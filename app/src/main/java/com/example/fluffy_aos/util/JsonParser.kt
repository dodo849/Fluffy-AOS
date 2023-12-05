package com.example.fluffy_aos.util

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class JsonParser<T> {
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    fun parse(jsonString: String, type: Class<T>): T? {
        val adapter = moshi.adapter(type)

        return try {
            adapter.fromJson(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}