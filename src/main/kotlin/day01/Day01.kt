package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01","day01Input")
    check(part1(testInput) == 2256)

    val input = readInput("day01","day01Input")
    part1(input).println()
    part2(input).println()

    val caloriesCounter = CaloriesCounter(input)

    println(caloriesCounter.getMaxCalories())

    println(caloriesCounter.getMaxCaloriesForElves(1))
    println(caloriesCounter.getMaxCaloriesForElves(3))
}
