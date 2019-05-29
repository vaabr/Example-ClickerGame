package com.example.recall.work

class Job(var salary: Int, val name: String) {
    fun plusSalary(num: Int) {
        salary += num
    }

    fun raiseSalary(percent: Int) {
        salary = salary * (percent + 100) / 100
    }
}