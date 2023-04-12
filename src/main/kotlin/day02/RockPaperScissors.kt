package day02

data class Punctuation(
    val pointsPerChoice: Int,
    val pointsPerOutcome: Int,
    val totalPoints: Int = pointsPerChoice + pointsPerOutcome
)
class RockPaperScissors(val fileInputs: List<String>) {
    fun getPlayPunctuations(): Array<Punctuation?>? {
        val allPlaysPunctuation = Array<Punctuation?>(fileInputs.size) { null }

        for (i in fileInputs.indices) {
            val (opponentChoice, playerChoice) = fileInputs[i].split(" ")

            val punctuation = getPunctuationObject(opponentChoice.first(), playerChoice.first()) ?: return null
            allPlaysPunctuation[i] = punctuation
        }
        return allPlaysPunctuation
    }

    private fun getPunctuationObject(opponentChar: Char, playerChar: Char): Punctuation? {
        val oppChoice = OpponentGameChoices.getAssociatedChoice(opponentChar) ?: return null
        val playerChoice = PlayerGameChoices.getAssociatedChoice(playerChar) ?: return null

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

    fun getFinalPunctuation(): Int? {
        val playPunctuations = getPlayPunctuations() ?: return null
        return playPunctuations.sumOf { it!!.totalPoints }
    }
}