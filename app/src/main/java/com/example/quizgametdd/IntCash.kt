package com.example.quizgametdd

import android.content.SharedPreferences

interface IntCash {

    fun save(newValue: Int)

    fun read(): Int

    class Base(
        private val key: String,
        private val sharedPreferences: SharedPreferences,
        private val defaultValue: Int
    ) : IntCash {
        override fun save(newValue: Int) {
            sharedPreferences.edit().putInt(key, newValue).apply()
        }

        override fun read(): Int {
            return sharedPreferences.getInt(key, defaultValue)
        }
    }
}