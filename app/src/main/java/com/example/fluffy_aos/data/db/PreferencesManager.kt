package com.example.fluffy_aos.data.db

import android.content.Context
import android.content.SharedPreferences

object PreferencesManager {

    private var helper: PreferencesManager.PreferencesHelper? = null

    fun init(context: Context) {
        helper = PreferencesHelper(context)
    }

    fun saveValue(key: String, value: String) {
        helper?.saveData(key, value)
    }

    fun getValue(key: String, defaultValue: String): String {
        return helper?.getData(key, defaultValue) ?: defaultValue
    }

    private class PreferencesHelper(context: Context) {
        private val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        fun saveData(key: String, value: String) {
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun getData(key: String, defaultValue: String): String {
            return sharedPreferences.getString(key, defaultValue) ?: defaultValue
        }
    }
}
