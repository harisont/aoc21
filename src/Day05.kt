package bho.harisont.aoc.day05

import java.io.File

typealias Point = Pair<Int,Int>

class LineOfVents(from: Point, to: Point) {
    val from = from
    val to = to

    fun x1(): Int {
        return this.from.first
    }

    fun x2(): Int {
        return this.to.first
    }

    fun y1(): Int {
        return this.from.second
    }

    fun y2(): Int {
        return this.to.second
    }

    fun isHorizontal(): Boolean {
        return this.x1() == this.x2()
    }

    fun isVertical(): Boolean {
        return this.y1() == this.y2()
    }

    fun isDiagonal(): Boolean {
        return !this.isHorizontal() && !this.isVertical() 
    }
}

fun <T> List<T>.toPair(): Pair<T, T> {
    if (this.size != 2) {
        throw IllegalArgumentException("List should be of length 2!")
    }
    return Pair(this[0], this[1])
}


fun readLinesOfVents(path: String): List<LineOfVents> {
    return File(path).readLines().map {
        val (from,to) = it.split(" -> ").map { 
            it.split(",").map {
                it.toInt()
            }.toPair()
        }
        LineOfVents(from, to)
    }
}

typealias Diagram = Array<Array<Int>>

fun linesOfVents2Diagram(lines: List<LineOfVents>): Diagram {
    val nonDiagonals = lines.filter { ! it.isDiagonal() }
    val rows = nonDiagonals.map { maxOf(it.y1(), it.y2()) }.maxOrNull()
    val cols = nonDiagonals.map { maxOf(it.x1(), it.x2()) }.maxOrNull()
    var diagram = Array(rows!! + 1) { Array(cols!! + 1) { 0 } }
    for (line in nonDiagonals) {
        if (line.isHorizontal()) {
            for (y in minOf(line.y1(), line.y2())..maxOf(line.y1(), line.y2())) {
                diagram[y][line.x1()] += 1
            }
        }
        else { // vertical line
            for (x in minOf(line.x1(), line.x2())..maxOf(line.x1(), line.x2())) {
                diagram[line.y1()][x] += 1
            }
        }
    }
    return diagram
}

fun nOverlaps(diagram: Diagram): Int {
    var n = 0
    for (i in 0..diagram.size - 1) {
        for (j in 0..diagram[0].size - 1)
            if (diagram[i][j] > 1)
                n += 1
    }
    return n
}

fun test05(linesOfVents: List<LineOfVents>) {
    assert(nOverlaps(linesOfVents2Diagram(linesOfVents)) == 6461)
}

fun part1(path: String): Int = 
    nOverlaps(linesOfVents2Diagram(readLinesOfVents(path)))
fun part2(path: String): Int = TODO()