package com.example.recall

import android.content.SharedPreferences

object Functions {
    const val longMax: Long = 9223372036854775807 //to do not google variable ranges
    const val longMin: Long = -9223372036854775807
    const val intMax: Int = 2147483647
    const val intMin: Int = -2147483648
    const val shortMax: Short = 32767
    const val shortMin: Short = -32768
    const val byteMax: Byte = 127
    const val byteMin: Byte = -128

    lateinit var sPref: SharedPreferences
    fun saveData(name: String, data: Any) {
        val ed = sPref.edit()
        when (data) {
            is Int -> ed.putInt(name, data)
            is String -> ed.putString(name, data)
            is Boolean -> ed.putBoolean(name, data)
            is Long -> ed.putLong(name, data)
        }
        ed.apply()
    }

    fun loadInt(name: String): Int {
        return sPref.getInt(name, 0)
    }

    fun loadBool(name: String): Boolean {
        return sPref.getBoolean(name, false)
    }

    fun loadString(name: String): String? {
        return sPref.getString(name, "NO_DATA")
    }

    fun loadLong(name: String): Long {
        return sPref.getLong(name, 0)
    }


    fun doNothing() {
        //it literally does nothing
    }
}