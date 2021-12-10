package bho.harisont.aoc.day03

import java.io.File

fun readDiagnostic(path: String): Array<Array<Int>> {
    return File(path).readLines().map {
        // toInt() returns code if applied to Char directly
        it.map { it.toString().toInt() }.toTypedArray()
    }.toTypedArray()
}

inline fun <reified T> transpose(xs: Array<Array<T>>): Array<Array<T>> {
    val cols = xs[0].size
    val rows = xs.size
    return Array(cols) { j ->
        Array(rows) { i -> 
            xs[i][j]
        }
    }
}

fun complement(n: Array<Int>): Array<Int> {
    return n.map { if (it != 0) 0 else 1 }.toTypedArray()
}

fun bin2dec(bin: Array<Int>): Int {
    bin.reverse() // bleah side effects!
    var dec = 0
    for (i in 0..bin.size - 1) {
        dec += bin[i] * (Math.pow(2.toDouble(), i.toDouble())).toInt()
    }
    return dec
}

fun powerConsumption(diagnostic: Array<Array<Int>>): Int {
    val gamma = transpose(diagnostic).map { 
        val zeroes = it.filter { it == 0 }.size
        val ones = it.filter { it == 1 }.size
        if (zeroes > ones) 0 else 1
    }.toTypedArray()
    val epsilon = complement(gamma)
    return bin2dec(gamma) * bin2dec(epsilon)
}

fun part1(path: String): Int = powerConsumption(readDiagnostic(path))
fun part2(path: String): Int? = null