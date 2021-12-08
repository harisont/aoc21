package bho.harisont.aoc

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

fun main() {
    val notes = readNotes("../data/day08.txt")
    println("Part 1: ${nEasyDigits(notes)}")
}