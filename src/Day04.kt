package bho.harisont.aoc.day04

import java.io.File

import bho.harisont.aoc.day03.transpose

class Cell(val n: Int, var marked: Boolean = false)

typealias Board = Array<Array<Cell>>

typealias Bingo = Pair<List<Int>,List<Board>>

fun parseBoard(txt: String): Board {

    fun parseRow(row: String): Array<Cell> {
        return row.split(" ")
            .filter { !it.isEmpty() }
            .map { Cell(it.toInt()) }
            .toTypedArray()
    }
    return txt.split("\\n".toRegex()).map { parseRow(it) }.toTypedArray()
}

fun readBingo(path: String): Bingo {
    val txt = File(path).readText()
    val blocks = txt.split("\\n\\n".toRegex())
    val ns = blocks[0].split(",").map { it.toInt() }
    val boards = blocks.slice(1..blocks.size - 1).map { parseBoard(it) }
    return Pair(ns,boards)
}

fun mark(n: Int, board: Board): Board {
    for (i in 0..board.size - 1) {
        for (j in 0..board[0].size - 1) {
            if (board[i][j].n == n)
                board[i][j].marked = true
        }
    }
    return board
}

fun hasWon(board: Board): Boolean {

    fun hasCompleteRow(board: Board): Boolean {
        return board.any { it.all { it.marked == true } }
    }
    
    fun hasCompleteColumn(board: Board): Boolean {
        return hasCompleteRow(transpose(board))
    }

    return hasCompleteRow(board) or hasCompleteColumn(board)
}

fun playBingo(bingo: Bingo): Pair<Board,Int>? {
    val (ns,boards) = bingo
    for (n in ns) {
        boards.map { 
            mark(n,it) 
            if (hasWon(it))
                return Pair(it,n)
        }
    }
    return null
}

fun score(win: Pair<Board,Int>?): Int? {
    if (win != null) {
        val sum = win.first
            .map { it.filter { !it.marked }.map { it.n }.sum() }.sum()
        val n = win.second
        return sum * n
    }
    return null
}


fun part1(path: String): Int? = score(playBingo(readBingo(path)))
fun part2(path: String): Int? = null