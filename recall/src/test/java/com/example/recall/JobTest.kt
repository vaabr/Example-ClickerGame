package com.example.recall

import com.example.recall.work.Job
import org.junit.Assert.assertEquals
import org.junit.Test

class JobTest {
    @Test
    fun plusSalary_isCorrect() {
        val testJob = Job(100, "test")
        testJob.plusSalary(0)
        assertEquals(100, testJob.salary)
        testJob.plusSalary(5)
        assertEquals(105, testJob.salary)
        testJob.plusSalary(-10)
        assertEquals(95, testJob.salary)
    }

    @Test
    fun raiseSalary_isCorrectPlus() {
        val testJob = Job(100, "test")
        testJob.raiseSalary(25)
        assertEquals(125, testJob.salary)
    }

    @Test
    fun raiseSalary_isCorrectMinus() {
        val testJob = Job(100, "test")
        testJob.raiseSalary(-25)
        assertEquals(75, testJob.salary)
    }

    @Test
    fun raiseSalary_isCorrectZero() {
        val testJob = Job(100, "test")
        testJob.raiseSalary(0)
        assertEquals(100, testJob.salary)
    }
}