package day01

import java.lang.Integer.max

class CountingCalories(val fileInputs: List<String>) {

    fun getMaxCalories(): Int {
        var maxCount = 0
        var currentCount = 0
        for (lineValue in fileInputs) {
            if (lineValue.isNotBlank()) {
                currentCount += lineValue.toInt()
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount
                }
                currentCount = 0
            }
        }
        return max(maxCount, currentCount)
    }

    fun getCaloriesSorted(): List<Int> {
        val elfCalories = mutableListOf<Int>()
        var currentElfCalories = 0
        for (lineValue in fileInputs) {
            if (lineValue.isNotBlank()) {
                currentElfCalories += lineValue.toInt()
                continue
            }
            elfCalories.add(currentElfCalories)
            currentElfCalories = 0
        }
        if (currentElfCalories != 0) elfCalories.add(currentElfCalories)
        elfCalories.sort()
        return elfCalories.toList()
    }

    fun getMaxCaloriesForElves(elvesQuantity: Int): Int? {
        if (elvesQuantity <= 0) return null

        var sum = 0
        val caloriesSorted = getCaloriesSorted()
        var caloriesLastIndex = caloriesSorted.size - 1

        if (elvesQuantity > caloriesSorted.size) return null

        for (j in 0 until elvesQuantity) {
            sum += caloriesSorted[caloriesLastIndex]
            caloriesLastIndex--
        }
        return sum
    }
}