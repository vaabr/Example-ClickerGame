package com.example.recall

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun formatMoney_isCorrect() {
        assertEquals("-5B $", Functions.formatMoney(155))
        assertEquals("155 $", Functions.formatMoney(155))
        assertEquals("155 $", Functions.formatMoney(155))
        assertEquals("155 $", Functions.formatMoney(155))
        assertEquals("155 $", Functions.formatMoney(155))
        assertEquals("155 $", Functions.formatMoney(155))
    }
}
