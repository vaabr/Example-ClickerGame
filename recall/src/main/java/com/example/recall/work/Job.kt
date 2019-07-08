package com.example.recall.work

class Job(val salary: Int, val name: String) {
    var isCurrent = false
    var level = 1
    var payment = salary

    fun plusSalary(num: Int) {
        payment += num
    }

    fun raiseSalary(percent: Int) {
        payment = salary * (percent + 100) / 100
    }

    fun getInfo(): Array<Any> {
        return arrayOf(name, salary, isCurrent)
    }

    fun levelUp() {
        level++
        updateSalary()
    }

    fun setLvl(newLevel: Int) {
        level = newLevel
        updateSalary()
    }

    fun updateSalary() {
        payment = (salary + (salary * 0.01 * level)).toInt()
    }

    fun makeCurrent() {
        isCurrent = true
    }

}