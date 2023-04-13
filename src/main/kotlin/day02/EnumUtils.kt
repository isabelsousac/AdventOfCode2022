package day02
enum class GameChoices(
    val associatedPlayerChar: Char,
    val associatedOpponentChar: Char,
    val point: Int
) {
    ROCK('X', 'A', 1),
    PAPER('Y', 'B',2),
    SCISSORS('Z', 'C',3);

    companion object {
        fun getAssociatedChoice(charChoice: Char): GameChoices? {
            return GameChoices.values().firstOrNull {
                it.associatedPlayerChar == charChoice || it.associatedOpponentChar == charChoice
            }
        }
    }
}

enum class GameOutcomesPunctuation(
    val points: Int
) {
    WIN(6),
    DRAW(3),
    LOST(0);
}