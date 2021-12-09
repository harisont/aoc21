package bho.harisont.aoc

import java.io.File
import kotlin.text.toCharArray

typealias Heatmap = List<List<Int>>

fun readHeatmap(path: String): Heatmap {
    return File(path).readLines().map {
        it.toCharArray().map { it.toString().toInt() }
    }
}

fun lowPoints(heatmap: Heatmap): List<Int> {

    fun isLowPoint(point: Pair<Int,Int>, heatmap: Heatmap): Boolean {
        val (i,j) = point
        val height = heatmap[i][j]
        val heightl = if (j - 1 >= 0) heatmap[i][j - 1] else null
        val heightu = if (i - 1 >= 0) heatmap[i - 1][j] else null
        val heightr = if (j + 1 < heatmap[0].size) heatmap[i][j + 1] else null
        val heightd = if (i + 1 < heatmap.size) heatmap[i + 1][j] else null
        return listOf(heightl, heightu, heightr, heightd)
                .filterNotNull()
                .all { it > height}
    }

    var lowPoints: MutableList<Int> = mutableListOf()

    for (i in 0..heatmap.size - 1) {
        for (j in 0..heatmap[0].size - 1) {
            if (isLowPoint(Pair(i,j), heatmap))
                lowPoints.add(heatmap[i][j])
        }
    }
    return lowPoints
}

fun riskLevel(n: Int): Int {
    return n + 1
}

fun main() {
    val heatmap = readHeatmap("../data/day09.txt")
    println("Part 1: ${lowPoints(heatmap).map { riskLevel(it) }.sum() }")
}