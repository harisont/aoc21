package bho.harisont.aoc.day10

import java.io.File
import java.util.ArrayDeque

typealias Stack = ArrayDeque<Char>

val parentheses = 
    setOf(Pair('(',')'), Pair('[',']'), Pair('{','}'), Pair('<','>'))

// just for fun cause extension functions are nice
fun Char.isOpening(): Boolean = this in parentheses.map { it.first }
fun Char.isClosing(): Boolean = this in parentheses.map { it.second }
fun Char.closes(opening: Char): Boolean = Pair(opening,this) in parentheses
fun Char.score(): Int = 
    when (this) { ')' -> 3; ']' -> 57; '}' -> 1197; '>' -> 25137; else -> 0 }

fun getFirstInvalidChar(s: String): Char? {
    var stack = Stack()
    for (c in s) {
        if (c.isOpening()) 
            stack.push(c)
        else if (c.closes(stack.peek())) 
            stack.pop()
        else return c
    }
    return null
}

fun part1(path: String): Int = File(path).readLines()
                                .map { getFirstInvalidChar(it) }
                                .filterNotNull()
                                .map { it.score() }
                                .sum()
                                
fun part2(path: String): Int = TODO()
