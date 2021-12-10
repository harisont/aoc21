package bho.harisont.aoc.day07

import java.io.File
import kotlin.math.abs

import bho.harisont.aoc.day06.readCommaSeparatedInts

typealias Pos = Int

fun totCost(position: Pos, positions: List<Pos>): Pos =
    positions.map { abs(it - position) }.sum()

fun minCost(positions: MutableList<Pos>): Pos {
    positions.sort()
    var minCost = totCost(positions[0], positions)
    for (position in positions.slice(1..positions.size - 1)) {
        val posCost = totCost(position, positions)
        if (posCost < minCost)
            minCost = posCost
    }
    return minCost
}


fun part1(path: String): Int = minCost(readCommaSeparatedInts(path))
fun part2(path: String): Int = TODO()