package com.example.fluffy_aos.util

import android.content.Context
import java.io.InputStream

class JsonReader(private val context: Context) {

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
