package day02

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
    val testInput = readInput("day02","day02Input")
    check(part1(testInput) == 2500)

    val input = readInput("day02","day02Input")
    part1(input).println()
    part2(input).println()

    val rockPaperScissors = RockPaperScissors(input)
    println(rockPaperScissors.getFinalPunctuation())
}
