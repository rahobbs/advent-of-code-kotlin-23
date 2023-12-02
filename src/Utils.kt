import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16)
        .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * Implements a Trie with terminal points indicated by the
 * existence of a Value
 */

class Trie<Value> {

    val root = Node<Value>()

    data class Node<Value>(
            val children: MutableMap<Char, Node<Value>> = mutableMapOf(),
            var value: Value? = null,
    )

    fun insert(key: String, value: Value) {
        var currentNode = root
        for (char in key) {
            if (currentNode.children[char] == null) {
                currentNode.children[char] = Trie.Node()
            }
            currentNode = currentNode.children[char]!!
        }
        currentNode.value = value
    }

    fun search(key: String): Value? {
        var currentNode = root
        for (char in key) {
            if (currentNode.children[char] == null) {
                return null
            }
            currentNode = currentNode.children[char]!!
        }
        return currentNode.value
    }

    fun contains(key: String): Value? {
        var currentNode = root
        for (char in key) {

            if (currentNode.children[char] == null) {
                return null
            }
            currentNode = currentNode.children[char]!!

            if (currentNode.value != null) {
                return currentNode.value
            }
        }
        return currentNode.value
    }
}
