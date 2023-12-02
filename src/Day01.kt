import java.lang.StringBuilder

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach {str ->
            var sb = StringBuilder()

            run breaking@ {
                str.forEach {
                    if(it.isDigit()) {
                        sb.append(it)
                        return@breaking
                    }
                }
            }

            for (i in str.length - 1 downTo 0) {
                if (str[i].isDigit()) {
                    sb.append(str[i])
                    break
                }
            }
            sum += sb.toString().toInt()
        }
        return sum
    }

    fun part2(input: List<String>): Int {

        val numTrie = Trie<Int>()
        numTrie.insert("one", 1)
        numTrie.insert("two", 2)
        numTrie.insert("three", 3)
        numTrie.insert("four", 4)
        numTrie.insert("five", 5)
        numTrie.insert("six", 6)
        numTrie.insert("seven", 7)
        numTrie.insert("eight", 8)
        numTrie.insert("nine", 9)

        val reverseTrie = Trie<Int>()
        reverseTrie.insert("eno", 1)
        reverseTrie.insert("owt", 2)
        reverseTrie.insert("eerht", 3)
        reverseTrie.insert("ruof", 4)
        reverseTrie.insert("evif", 5)
        reverseTrie.insert("xis", 6)
        reverseTrie.insert("neves", 7)
        reverseTrie.insert("thgie", 8)
        reverseTrie.insert("enin", 9)

        var sum = 0

        input.forEach { str ->
            val sb = StringBuilder()

            run breaking@ {
                str.forEachIndexed{i, ch ->
                    if (ch.isDigit()) {
                        sb.append(ch)
                        return@breaking
                    } else {
                        val substring = str.substring(i, str.length -1)
                        val searchResult = numTrie.contains(substring)
                        if (searchResult != null) {
                            sb.append(searchResult.toString())
                            return@breaking
                        }
                    }
                }
            }

            val reversed = str.reversed()

            run breaking@ {
                reversed.forEachIndexed{i, ch ->
                    if (ch.isDigit()) {
                        sb.append(ch)
                        return@breaking
                    } else {
                        val substring = reversed.substring(i, reversed.length -1)
                        val searchResult = reverseTrie.contains(substring)
                        if (searchResult != null) {
                            sb.append(searchResult.toString())
                            return@breaking
                        }
                    }
                }
            }
            sum += sb.toString().toInt()

        }

        return sum
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

