package day02

import java.lang.IllegalArgumentException

data class Punctuation(
    val pointsPerChoice: Int,
    val pointsPerOutcome: Int,
    val totalPoints: Int = pointsPerChoice + pointsPerOutcome
)
class RockPaperScissors(val fileInputs: List<String>) {

    private fun getPunctuationObject(opponentChar: Char, playerChar: Char): Punctuation {
        val oppChoice = OpponentGameChoices.getAssociatedChoice(opponentChar) ?: throw IllegalArgumentException("$opponentChar is not a valid option")
        val playerChoice = PlayerGameChoices.getAssociatedChoice(playerChar) ?: throw IllegalArgumentException("$playerChar is not a valid option")

        val outcomePoint = when {
            oppChoice.name == playerChoice.name -> GameOutcomesPunctuation.DRAW.points
            (oppChoice == OpponentGameChoices.ROCK && playerChoice == PlayerGameChoices.PAPER) ||
            (oppChoice == OpponentGameChoices.PAPER && playerChoice == PlayerGameChoices.SCISSORS) ||
            (oppChoice == OpponentGameChoices.SCISSORS && playerChoice == PlayerGameChoices.ROCK)
            -> {
                GameOutcomesPunctuation.WIN.points
            }
            else -> GameOutcomesPunctuation.LOST.points
        }

        return Punctuation(pointsPerChoice = playerChoice.point, pointsPerOutcome = outcomePoint)
    }

    fun getFinalPunctuation(): Int =
        fileInputs.map {
            val (opponentChoice, playerChoice) = it.split(" ")
            getPunctuationObject(opponentChoice.first(), playerChoice.first())
        }.sumOf { it.totalPoints }
    
}