package bho.harisont.aoc.day01

import java.io.File

fun readReport(path: String): List<Int> {
    return File(path).readLines().map{ it.toInt() }
}


fun nIncreases(ints: List<Int>): Int {
    var increases = 0
    for (i in 0..ints.size - 2) {
        if (ints[i + 1] > ints[i])
            increases++
    }
    return increases
}

fun n3Increases(ints: List<Int>): Int {
    var increases = 0
    for (i in 0..ints.size - 4) {
        if (ints.slice(i + 1..i + 3).sum() > ints.slice(i..i + 2).sum())
            increases++
    }
    return increases
}

fun part1(path: String): Int = nIncreases(readReport(path))
fun part2(path: String): Int = n3Increases(readReport(path))