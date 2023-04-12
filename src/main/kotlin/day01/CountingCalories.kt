package day01

import readInput

class CountingCalories {
    val day1File = readInput("Day01")

    fun countCalories() {
        var maxCount = 0
        var currentCount = 0
        for (lineValue in day1File) {
            if (lineValue.isNotEmpty()) {
                currentCount += lineValue.toInt()
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount
                    currentCount = 0
                }
            }
        }
    }
}