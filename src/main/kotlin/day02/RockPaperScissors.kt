package day02

import day02.GameOutcomesPunctuation.*

data class Punctuation(
    val pointsPerChoice: Int,
    val pointsPerOutcome: Int,
    val totalPoints: Int = pointsPerChoice + pointsPerOutcome
)

class RockPaperScissors(val fileInputs: List<String>) {
    fun getPunctuationObject(opponentChar: Char, playerChar: Char): Punctuation {
        val oppChoice = GameChoices.getAssociatedChoice(opponentChar)
        val playerChoice = GameChoices.getAssociatedChoice(playerChar)
        val playerOutcomes = playerChoice.getOutcomes()

        val outcomePoint = when (oppChoice) {
            playerOutcomes.drawsAgainst -> DRAW.points
            playerOutcomes.losesAgainst -> LOST.points
            playerOutcomes.winsAgainst -> WIN.points
            else -> 0
        }

        return Punctuation(pointsPerChoice = playerChoice.point, pointsPerOutcome = outcomePoint)
    }

    fun getFinalPunctuation(): Int =
        fileInputs.map {
            val (opponentChoice, playerChoice) = it.split(" ")
            getPunctuationObject(opponentChoice.first(), playerChoice.first())
        }.sumOf { it.totalPoints }

    private fun getPunctuationStrategyGuideObject(opponentChar: Char, playerChar: Char): Punctuation {
        val oppChoice = GameChoices.getAssociatedChoice(opponentChar)
        val desiredOutcome = GameOutcomesPunctuation.getAssociatedChoice(playerChar)
        val oppOutcomes = oppChoice.getOutcomes()
        val playerChoice = when (desiredOutcome) {
            WIN -> oppOutcomes.losesAgainst
            DRAW -> oppOutcomes.drawsAgainst
            LOST -> oppOutcomes.winsAgainst
        }

        return Punctuation(pointsPerChoice = playerChoice.point, pointsPerOutcome = desiredOutcome.points)
    }

    fun getStrategyGuidePunctuation(): Int =
        fileInputs.map {
            val (opponentChoice, playerChoice) = it.split(" ")
            getPunctuationStrategyGuideObject(opponentChoice.first(), playerChoice.first())
        }.sumOf { it.totalPoints }
}