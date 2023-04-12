package day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountingCaloriesTest {
    val subject = CountingCalories()

    @Test
    fun `if file contains a list with more than one Elf calories, output should be the greatest calorie count`() {
        val input = listOf("1", "2", "3", "4", "5", " ", "34")
        val result = subject.getMaxCalories(input)
        assertEquals(34, result)
    }

    @Test
    fun `if file contains a list with only one Elf calorie, output should be the calorie count`() {
        val input = listOf("34")
        val result = subject.getMaxCalories(input)
        assertEquals(34, result)
    }

    @Test
    fun `if file does not contain any Elf calorie, output should be 0`() {
        val input = listOf<String>()
        val result = subject.getMaxCalories(input)
        assertEquals(0, result)
    }

    @Test
    fun `qif file does not contain any Elf calorie, output should be 0`() {
        val input = listOf("1000", "2000", "3000", "4000", " ", "5000", "6000", " ", "7000", "8000", "9000", " ", "10000")
        val result = subject.getMaxCalories(input)
        assertEquals(24000, result)
    }
}