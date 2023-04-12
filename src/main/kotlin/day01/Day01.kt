package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        println(input.filter { it.isNotEmpty() })
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01")
    check(part1(testInput) == 2256)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
