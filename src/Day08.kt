package bho.harisont.aoc.day08

import java.io.File
import kotlin.text.toCharArray

typealias Note = Pair<List<Set<Char>>, List<Set<Char>>>

fun readNotes(path: String): List<Note> {
    return File(path).readLines().map { 
        val s = it.split(" | ").map { 
            it.split(" ").map { it.toCharArray().toSet() } 
        }
        Pair(s[0], s[1])
    }
}

fun nEasyDigits(notes: List<Note>): Int {
    var n = 0
    for (note in notes) {
        for (set in note.second) {
            if (set.size in listOf(2, 3, 4, 7))
                n += 1
        }
    }
    return n
}

fun part1(path: String): Int = nEasyDigits(readNotes(path))
fun part2(path: String): Int = TODO()
