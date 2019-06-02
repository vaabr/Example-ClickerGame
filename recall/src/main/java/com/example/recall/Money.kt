package com.example.recall

import kotlin.math.abs

object Money {
    var money = 0
    var multiplier = 0

    fun countMultiplier(x: Int): Int{
        var mult = 0
        for(g in 1 until abs(x).toString().length){
            if(g%3==0) mult++
        }
        return mult
    }

    fun disassemble(value: Int): Array<Int?>{
        var num = value
        val mult = countMultiplier(num)+1
        val array = arrayOfNulls<Int>(mult)
        for (i in 0 until mult){
            array[i]=num%1000
            num /= 1000
        }
        return array
    }

    fun increaseMoney(amount: Int){
        Functions.doNothing()
    }
}