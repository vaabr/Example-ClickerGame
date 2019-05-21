package com.example.recall

import android.content.SharedPreferences
import android.view.View
import android.widget.TextView

object Functions {

    lateinit var sPref: SharedPreferences

    fun saveData(name: String, data: Any) {
        val ed = sPref.edit()
        when (data) {
            is Int -> ed.putInt(name, data)
            is String -> ed.putString(name, data)
            is Boolean -> ed.putBoolean(name, data)
        }
        ed.commit()
    }

    fun loadInt(name: String): Int {
        return sPref.getInt(name, 0)
    }

    fun loadBool(name: String): Boolean{
        return sPref.getBoolean(name, false)
    }

    fun loadString(name: String): String?{
        return sPref.getString(name, "NO_DATA")
    }

    fun formatMoney(money: Int): String{
        return when(money){
            in 0 until 1000 -> ("$money $")
            in 1000 until 1000000 -> ((money/1000).toString() + "," + ((money/100)%10).toString() + "K $")
            in 1000000 until 1000000000 -> ((money/1000000).toString() + "," + ((money/100000)%10).toString() + "M $")
            in 1000000000 until 1000000000000 -> ((money/1000000000).toString() + "," + ((money/100000000)%10).toString() + "B $")
            else -> (money.toString())
        }
    }
}