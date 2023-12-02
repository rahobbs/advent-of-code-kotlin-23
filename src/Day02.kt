fun main() {

    val mapToCheck = mapOf("red" to 12, "green" to 13, "blue" to 14)

    fun part1(input: List<String>): Int {
        var sum = 0

        input.forEach breaking@ { game ->
            val parts = game.split(":")
            val gameId = parts.first().removePrefix("Game ").toInt()

            val draws = parts.last().split(';')
            draws.forEach{ draw ->
                val colors = draw.split(',')
                colors.forEach { color ->
                    val pair = color.trimStart().split(" ")

                    if (mapToCheck[pair.last()] == null || mapToCheck[pair.last()]!! - pair.first().toInt() < 0) {
                        // continue to next game
                        return@breaking
                    } else {
                        // continue to next draw
                    }
                }
            }
            sum += gameId
        }
        return sum
    }


    fun part2(input: List<String>): Int {
        return input.size
    }

// test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day02_test")
//    val result = part1(testInput)
    //check(part1(testInput) == 1)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}