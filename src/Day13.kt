package bho.harisont.aoc.day13

import java.io.File

typealias Point = Pair<Int,Int>

typealias Offset = Int

enum class Axis {
    X, Y
}

class Fold(axis: Axis, offset: Offset) {
    val axis = axis
    val offset = offset
}

fun readOrigamiInstructions(path: String): Pair<List<Point>, List<Fold>> {
    val (part1,part2) = File(path).readText().split("\n\n")
    val points = part1.split("\n")
        .map { it.split(",").map { it.toInt() } }
        .map { Pair(it[0], it[1]) }
    val folds = part2.split("\n").filter{ it != "" }
        .map { it.split(" ").last().split("=") }
        .map {Fold(if (it[0] == "x") Axis.X else Axis.Y, it[1].toInt())}
    return Pair(points, folds)
}

fun transparentSheet(points: List<Point>): Array<Array<Boolean>> {
    val rows = points.map { it.second }.maxOrNull()!! + 1
    val cols = points.map { it.first }.maxOrNull()!! + 1
    var matrix = Array(rows) { _ -> Array(cols) { _ -> false } }
    for (point in points) {
        matrix[point.second][point.first] = true
    }
    return matrix
}

fun fold(sheet: Array<Array<Boolean>>, fold: Fold): Array<Array<Boolean>> {
    if (fold.axis == Axis.X) {
        return Array(sheet.size) { i ->
            Array(sheet[0].size / 2) { j -> 
                sheet[i][j] || sheet[i][sheet[0].size - 1 - j]
            }
        }
    }
    else {
        return Array(sheet.size / 2) { i ->
            Array(sheet[0].size) { j -> 
                sheet[i][j] || sheet[sheet.size - 1 - i][j]
            }
        }
    }
} 

fun printSheet(sheet: Array<Array<Boolean>>) {
    for (i in 0..sheet.size - 1) {
        print("\n")
        for (j in 0..sheet[0].size - 1)
            print(if (sheet[i][j]) "#" else ".")
    }
}

fun foldR(sheet: Array<Array<Boolean>>, folds: List<Fold>): Array<Array<Boolean>> {
    if (folds.size == 0)
        return sheet
    else return foldR(fold(sheet, folds[0]), folds.slice(1..folds.size - 1))
}

fun part1(path: String): Int {
    val (points,folds) = readOrigamiInstructions(path)
    val sheet = transparentSheet(points)
    val folded = fold(sheet, folds[0])
    return folded.map { it.filter { it }.size }.sum()
}
fun part2(path: String): Int {
    val (points,folds) = readOrigamiInstructions(path)
    val sheet = transparentSheet(points)
    val folded = foldR(sheet,folds)
    printSheet(folded)
    return 0
} 