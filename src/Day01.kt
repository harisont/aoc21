package bho.harisont.aoc.day01

import java.io.File

fun readReport(path: String): List<Int> =
    File(path).readLines().map{ it.toInt() }

fun nIncreases(ns: List<Int>, win: Int=1): Int {
    var increases = 0
    for (i in 0..ns.size - (win + 1)) {
        if (ns.slice(i + 1..i + win).sum() > ns.slice(i..i + (win - 1)).sum())
            increases++
    }
    return increases
}

fun part1(path: String): Int = nIncreases(readReport(path))
fun part2(path: String): Int = nIncreases(readReport(path), 3)