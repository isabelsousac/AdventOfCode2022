package day02

import java.lang.IllegalArgumentException

enum class GameChoices(
    val point: Int,
) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    fun getOutcomes() =
        when (this) {
            ROCK -> GameOutcomes(
                drawsAgainst = ROCK,
                winsAgainst = SCISSORS,
                losesAgainst = PAPER
            )
            PAPER -> GameOutcomes(
                drawsAgainst = PAPER,
                winsAgainst = ROCK,
                losesAgainst = SCISSORS
            )
            SCISSORS -> GameOutcomes(
                drawsAgainst = SCISSORS,
                winsAgainst = PAPER,
                losesAgainst = ROCK
            )
        }

    companion object {
        fun getAssociatedChoice(charChoice: Char): GameChoices =
            when (charChoice) {
                'X', 'A' -> ROCK
                'Y', 'B' -> PAPER
                'Z', 'C' -> SCISSORS
                else -> throw IllegalArgumentException("$charChoice is not a valid option")
            }
    }
}

data class GameOutcomes(
    val drawsAgainst: GameChoices,
    val winsAgainst: GameChoices,
    val losesAgainst: GameChoices
)
enum class GameOutcomesPunctuation(
    val points: Int
) {
    WIN(6),
    DRAW(3),
    LOST(0);
    companion object {
        fun getAssociatedChoice(charChoice: Char) =
            when (charChoice) {
                'X' -> LOST
                'Y' -> DRAW
                'Z' -> WIN
                else -> throw IllegalArgumentException("$charChoice is not a valid option")
            }
    }
}