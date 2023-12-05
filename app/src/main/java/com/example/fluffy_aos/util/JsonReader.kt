package com.example.fluffy_aos.util

import android.content.Context
import java.io.InputStream

object JsonReader {

    private var jsonReader: _JsonReader? = null

    fun init(context: Context) {
        jsonReader = _JsonReader(context)
    }

    fun readJsonFile(fileName: String): String {
        return jsonReader!!.readJsonFile(fileName)
    }

    private class _JsonReader(private val context: Context) {

        fun readJsonFile(fileName: String): String {
            val resourceId = context.resources.getIdentifier(fileName, "raw", context.packageName)

            return try {
                val inputStream: InputStream = context.resources.openRawResource(resourceId)
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                inputStream.close()
                String(buffer)
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }
    }

}