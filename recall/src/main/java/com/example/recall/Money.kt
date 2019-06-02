package com.example.recall

import java.util.*
import kotlin.math.abs

object Money {
    var money = 0
    var multiplier = 0
    val moneyStack = Stack<Int>()

    fun countMultiplier(value: Int): Int{
        var mult = 0
        for(g in 1 until abs(value).toString().length){
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

    fun packToStack(array: Array<Int?>): Stack<Int>{
        val stack = Stack<Int>()
        for(i in array.size until 0){
            stack.push(array[i])
        }
        return stack
    }

    fun increaseMoney(amount: Int){
        Functions.doNothing()
    }
}