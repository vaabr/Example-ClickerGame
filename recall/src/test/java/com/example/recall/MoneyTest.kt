package com.example.recall

import com.example.recall.Money.countMultiplier
import com.example.recall.Money.disassemble
import com.example.recall.Money.getMoneyFromStack
import com.example.recall.Money.getValueFromEmptyStack
import com.example.recall.Money.getValueFromStack
import com.example.recall.Money.money
import com.example.recall.Money.moneyStack
import com.example.recall.Money.packToStack
import com.example.recall.Money.stackToArrayList
import com.example.recall.Money.stackToZero
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class MoneyTest {

    @Test
    fun countMultiplier_isCorrect() {
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
    fun disassemble_isCorrect() {
        var array = disassemble(5000)
        assertEquals(0, array[0])
        assertEquals(5, array[1])
        array = disassemble(1500700)
        assertEquals(700, array[0])
        assertEquals(500, array[1])
        assertEquals(1, array[2])
    }

    @Test
    fun moneyStack_isCorrect() {
        moneyStack.push(1)
        moneyStack.push(2)
        moneyStack.push(3)
        assertEquals(3, moneyStack.pop())
        assertEquals(2, moneyStack.pop())
        assertEquals(1, moneyStack.pop())
    }

    @Test
    fun packToStack_isCorrect() {
        val testArray = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val testNullsArray = arrayOfNulls<Int>(testArray.size)
        for (i in 0 until testArray.size) {
            testNullsArray[i] = testArray[i]
        }
        val testStack = packToStack(testNullsArray)
        for (i in 0 until testStack.size) {
            assertEquals(i, testStack.pop())
        }
        assertEquals(true, testStack.isEmpty())
    }

    @Test
    fun getMoneyFromStack_isCorrect() {
        money = 15700
        assertEquals(15, getMoneyFromStack())
        assertEquals(15, getMoneyFromStack())
        assertEquals(15, moneyStack.pop())
        assertEquals(700, getMoneyFromStack())
    }

    @Test
    fun getValueFromStack_isCorrect(){
        val stack = Stack<Int>()
        for(i in 0 until 10) {
            stack.push(i)
        }
        assertEquals(9, getValueFromStack(stack))
        assertEquals(9, getValueFromStack(stack))
    }

    @Test
    fun getValueFromEmptyStack_isCorrect(){
        val stack = Stack<Int>()
        val value = 15700
        assertEquals(15, getValueFromEmptyStack(stack, value))
        assertEquals(15, getValueFromEmptyStack(stack, value))
    }

    @Test
    fun somTest(){
        val stack = Stack<Int>()
        assertEquals(true, stack.isEmpty())
        val stack2 = Stack<Int>()
        stack2.push(0)
        assertEquals(false, stack2.isEmpty())
    }

    @Test
    fun getValueFromEmptyStack_Test(){
        var value = 15700
        val testStack: Stack<Int>
        val array = disassemble(value)
        assertEquals(700, array[0])
        assertEquals(15, array[1])
        testStack = packToStack(array)
        assertEquals(false, testStack.isEmpty())
        assertEquals(15, testStack.peek())
        value = testStack.peek()
        assertEquals(15, value)
    }

    @Test
    fun stackToZero_isCorrect(){
        val testStack = Stack<Int>()
        stackToZero(testStack)
        assertEquals(0, testStack.peek())
        testStack.push(5)
        assertEquals(5, testStack.pop())
        assertEquals(0, testStack.pop())
        assertEquals(true, testStack.isEmpty())
    }

    @Test
    fun stackToArrayList_isCorrect(){
        val testStack = Stack<Int>()
        val testArrayList = ArrayList<Int>()
        testStack.push(1)
        testStack.push(2)
        testStack.push(3)
        stackToArrayList(testStack, testArrayList)
        assertEquals(1, testArrayList[0])
        assertEquals(2, testArrayList[1])
        assertEquals(3, testArrayList[2])
        assertEquals(true, testStack.isEmpty())
    }
}