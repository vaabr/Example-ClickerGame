package com.example.recall

import org.junit.Assert.assertEquals
import org.junit.Test

class MoneyTest {
    @Test
    fun test(){
        Money.notEnough()
        assertEquals(0,0)
    }
}