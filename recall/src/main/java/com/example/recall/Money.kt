package com.example.recall

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

object Money {
    var money = 0
    var multiplier = 0
    var moneyStack = Stack<Int>()
    var moneyArray = ArrayList<Int>()

    fun countMultiplier(value: Int): Int {
        var mult = 0
        for (g in 1 until abs(value).toString().length) {
            if (g % 3 == 0) mult++
        }
        return mult
    }

    fun disassemble(value: Int): Array<Int?> {
        var num = value
        val mult = countMultiplier(num) + 1
        val array = arrayOfNulls<Int>(mult)
        for (i in 0 until mult) {
            array[i] = num % 1000
            num /= 1000
        }
        return array
    }

    fun packToStack(array: Array<Int?>): Stack<Int> {
        val stack = Stack<Int>()
        for (i in array.size until 0) {
            stack.push(array[i])
        }
        return stack
    }

    fun getMoneyFromStack(): Int {
        if (moneyStack.isEmpty()) {
            val array = disassemble(money)
            moneyStack = packToStack(array)
        }
        return moneyStack.peek()
    }

    fun getValueFromStack(stack: Stack<Int>): Int {
        return stack.peek()
    }

    fun getValueFromEmptyStack(stack: Stack<Int>, value: Int): Int {
        var stackVar = stack
        val array = disassemble(value)
        stackVar = packToStack(array)
        return stackVar.peek()
    }

    fun editMoney(amount: Int) {
        Functions.doNothing()
    }

    fun stackToZero(stack: Stack<Int>) {
        if (stack.isEmpty()) stack.push(0)
        else while (stack.isNotEmpty()) {
            stack.pop()
        }
    }

    //broken
    fun stackToArrayList(stack: Stack<Int>, arrayList: ArrayList<Int>) {
        if (arrayList.isNotEmpty()) arrayList.clear()
        for(i in (stack.size-1)..0) {
            arrayList[i] = stack.pop()
        }
    }



}