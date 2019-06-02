package com.example.recall

import com.example.recall.Money.countMultiplier
import com.example.recall.Money.disassemble
import com.example.recall.Money.moneyStack
import com.example.recall.Money.packToStack
import org.junit.Assert.assertEquals
import org.junit.Test

class MoneyTest {

    @Test
    fun countMultiplier_isCorrect(){
        assertEquals(0, countMultiplier(0))
        assertEquals(1, countMultiplier(1000))
        assertEquals(1, countMultiplier(-5000))
        assertEquals(2, countMultiplier(1000000))
        assertEquals(2, countMultiplier(-5000000))
        assertEquals(3, countMultiplier(1000000000))
        assertEquals(0, countMultiplier(100))
        assertEquals(1, countMultiplier(20000))
        assertEquals(1, countMultiplier(150000))
        assertEquals(2, countMultiplier(1500000))
        assertEquals(2, countMultiplier(555555555))
    }

    @Test
    fun disassemble_isCorrect(){
        var array = disassemble(5000)
        assertEquals(0, array[0])
        assertEquals(5, array[1])
        array = disassemble(1500700)
        assertEquals(700, array[0])
        assertEquals(500, array[1])
        assertEquals(1, array[2])
    }

    @Test
    fun moneyStack_isCorrect(){
        moneyStack.push(1)
        moneyStack.push(2)
        moneyStack.push(3)
        assertEquals(3, moneyStack.pop())
        assertEquals(2, moneyStack.pop())
        assertEquals(1, moneyStack.pop())
    }

    @Test
    fun packToStack_isCorrect(){
        val testArray = arrayOf(0,1,2,3,4,5,6,7,8,9)
        val testNullsArray = arrayOfNulls<Int>(testArray.size)
        for(i in 0 until testArray.size){
            testNullsArray[i]=testArray[i]
        }
        val testStack = packToStack(testNullsArray)
        for(i in 0 until testStack.size){
            assertEquals(i, testStack.pop())
        }
        assertEquals(true, testStack.isEmpty())
    }
}