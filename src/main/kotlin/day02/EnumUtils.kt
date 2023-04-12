package day02

enum class OpponentGameChoices(
    val associatedChar: Char
) {
    ROCK('A'),
    PAPER('B'),
    SCISSORS('C');

    companion object {
        fun getAssociatedChoice(charChoice: Char): OpponentGameChoices? {
            return values().firstOrNull { it.associatedChar == charChoice }
        }
    }
}


enum class PlayerGameChoices(
    val associatedChar: Char,
    val point: Int
) {
    ROCK('X', 1),
    PAPER('Y', 2),
    SCISSORS('Z', 3);

    companion object {
        fun getAssociatedChoice(charChoice: Char): PlayerGameChoices? {
            return PlayerGameChoices.values().firstOrNull { it.associatedChar == charChoice }
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