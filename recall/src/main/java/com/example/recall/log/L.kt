package com.example.recall.log

import android.util.Log
import com.example.recall.BuildConfig

object L {
    fun s() {
        log("started")
    }

    fun e() {
        log("ended")
    }

    private fun log(text: String) {
        if (BuildConfig.DEBUG) {
            val methodName = Throwable().stackTrace[2].methodName
            val className: String = Throwable().stackTrace[2].className
            Log.d(className, "$methodName function $text")
            println("$methodName function $text in $className class")
        }
    }
}