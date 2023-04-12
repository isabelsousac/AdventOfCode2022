package day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountingCaloriesTest {
    /**
     * Tests for first problem -> always outputting only the max calorie from one Elf
     */
    @Test
    fun `if file contains a list with more than one Elf calories, output should be the greatest calorie count`() {
        val input = listOf("1", "2", "3", "4", "5", " ", "34")
        val subject = CaloriesCounter(input)

        assertEquals(34, subject.getMaxCalories())
    }

    @Test
    fun `if file contains a list with only one Elf calorie, output should be the calorie count`() {
        val input = listOf("34")
        val subject = CaloriesCounter(input)

        assertEquals(34, subject.getMaxCalories())
    }

    @Test
    fun `if file does not contain any Elf calorie, output should be 0`() {
        val subject = CaloriesCounter(listOf())
        assertEquals(0, subject.getMaxCalories())
    }

    @Test
    fun `if file contains a list with more than one Elf calories with high values, output should be the greatest calorie count`() {
        val input = listOf("1000", "2000", "3000", "4000", " ", "5000", "6000", " ", "7000", "8000", "9000", " ", "10000")
        val subject = CaloriesCounter(input)

        assertEquals(24000, subject.getMaxCalories())
    }

    /**
     * Tests for second problem -> outputting max calorie from a given number of Elves
     */

    @Test
    fun `if input is 2, output should be the total calorie count from the 3 elves that have more calories`() {
        val input = listOf("1", "2", " ", "3", "4", "5", " ", "34")
        val subject = CaloriesCounter(input)

        assertEquals(46, subject.getMaxCaloriesForElves(2))
    }

    @Test
    fun `if input is 1, output should be the max calories count`() {
        val input = listOf("1", "2", " ", "3", "4", "5", " ", "34")
        val subject = CaloriesCounter(input)

        assertEquals(34, subject.getMaxCaloriesForElves(1))
    }

    @Test
    fun `if input is bigger than calories list size, output should be null`() {
        val input = listOf("1", "2", " ", "3", "4", "5", " ", "34")
        val subject = CaloriesCounter(input)

        assertNull(subject.getMaxCaloriesForElves(5))
    }
    @Test
    fun `if calories list is empty, getMaxCaloriesForElves should return null`() {
        val subject = CaloriesCounter(listOf())
        assertNull(subject.getMaxCaloriesForElves(0))
    }

    /**
     * Test for helper function
     */
    @Test
    fun `when input list finishes with a string number, output should contain the input string list as an integer list sorted`() {
        val input = listOf("1", "2", " ", "3", "4", "5", " ", "34")
        val subject = CaloriesCounter(input)

        val expected = listOf(3, 12, 34)
        assertEquals(expected, subject.getCaloriesSorted())
    }

    @Test
    fun `when input list finishes with an empty string, output should contain the input string list as an integer list sorted`() {
        val input = listOf("1", "2", " ", "3", "4", "5", " ", "34", " ")
        val subject = CaloriesCounter(input)

        val expected = listOf(3, 12, 34)
        assertEquals(expected, subject.getCaloriesSorted())
    }
}