fun main() {

    val mapToCheck = mapOf("red" to 12, "green" to 13, "blue" to 14)

    fun part1(input: List<String>): Int {
        var sum = 0

        input.forEach {
            // TODO: Extract GameID

            // For each draw
                // For each color
                    // val diff = mapToCheck[color] - drawColorFrequency
                    // if diff is negative, go to next game
            // Add gameId to sum


        }

        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}