package bho.harisont.aoc.day10

import java.io.File
import java.util.ArrayDeque
import kotlin.math.ceil

typealias Stack = ArrayDeque<Char>

val parentheses = 
    setOf(Pair('(',')'), Pair('[',']'), Pair('{','}'), Pair('<','>'))

// just for fun cause extension functions are nice
fun Char.isOpening(): Boolean = this in parentheses.map { it.first }
fun Char.isClosing(): Boolean = this in parentheses.map { it.second }
fun Char.closes(opening: Char): Boolean = Pair(opening,this) in parentheses
fun Char.score(): Int = 
    when (this) { 
        ')' -> 3; ']' -> 57; '}' -> 1197; '>' -> 25137; 
        '(' -> 1; '[' -> 2; '{' -> 3; '<' -> 4; 
        else -> 0 }

fun getFirstInvalidCharAndStack(s: String): Pair<Char?,Stack> {
    var stack = Stack()
    for (c in s) {
        if (c.isOpening()) 
            stack.push(c)
        else if (c.closes(stack.peek())) 
            stack.pop()
        else return Pair(c, stack)
    }
    return Pair(null, stack)
}

fun completionScore(stack: Stack): Int {
    var score = 0
    for (c in stack.reversed()) {
        score = score * 5 + c.score()
    }
    return score
}

fun middle(ns: MutableList<Int>): Int {
    ns.sort()
    return ns[(ceil((ns.size / 2).toFloat())).toInt()]
}

fun part1(path: String): Int = File(path).readLines()
                                .map { getFirstInvalidCharAndStack(it) }
                                .map { it.first }
                                .filterNotNull()
                                .map { it.score() }
                                .sum()
                                
fun part2(path: String): Int {
    val scores = File(path).readLines()
        .map { getFirstInvalidCharAndStack(it) }
        .filter { it.first == null }
        .map { it.second }
        .map { completionScore(it) }
        .toMutableList()
    return middle(scores)
}

